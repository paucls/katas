package com.kata.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehouseDeskApp {
    private final Map<String, Integer> stockBySku = new HashMap<>();
    private final Map<String, Integer> reservedBySku = new HashMap<>();
    private final Map<String, Double> priceBySku = new HashMap<>();
    private final Map<String, Order> orders = new HashMap<>();
    private final List<String> eventLog = new ArrayList<>();
    private final Map<String, Reservation> reservations = new HashMap<>();
    private double cashBalance;
    private int nextOrderNumber;
    private int nextReservationNumber;
    private long currentTimeMillis;

    public void seedData() {
        stockBySku.put("PEN-BLACK", 40);
        stockBySku.put("PEN-BLUE", 25);
        stockBySku.put("NOTE-A5", 15);
        stockBySku.put("STAPLER", 4);

        reservedBySku.put("PEN-BLACK", 0);
        reservedBySku.put("PEN-BLUE", 0);
        reservedBySku.put("NOTE-A5", 0);
        reservedBySku.put("STAPLER", 0);

        priceBySku.put("PEN-BLACK", 1.5);
        priceBySku.put("PEN-BLUE", 1.6);
        priceBySku.put("NOTE-A5", 4.0);
        priceBySku.put("STAPLER", 12.0);

        cashBalance = 300.0;
        nextOrderNumber = 1001;
        nextReservationNumber = 1;
        currentTimeMillis = System.currentTimeMillis();
    }


    public void runDemoDay() {
        List<String> commands = List.of(
            "RECV;NOTE-A5;5;2.20",
            "SELL;alice;PEN-BLACK;10",
            "SELL;bob;STAPLER;5",
            "CANCEL;O1002",
            "COUNT;STAPLER",
            "SELL;carol;STAPLER;2",
            "SELL;dan;NOTE-A5;14",
            "COUNT;NOTE-A5",
            "DUMP"
        );

        for (String command : commands) {
            processLine(command);
        }
        printEndOfDayReport();
    }

    public void processLine(String line) {
        String[] parts = line.split(";");
        String type = parts[0];

        if ("RECV".equals(type)) {
            handleRecvCommand(parts);
            return;
        }

        if ("SELL".equals(type)) {
            handleSellCommand(parts);
            return;
        }

        if ("CANCEL".equals(type)) {
            handleCancelCommand(parts);
            return;
        }

        if ("COUNT".equals(type)) {
            handleCountCommand(parts);
            return;
        }

        if ("RESERVE".equals(type)) {
            handleReserveCommand(parts);
            return;
        }

        if ("CONFIRM".equals(type)) {
            handleConfirmCommand(parts);
            return;
        }

        if ("RELEASE".equals(type)) {
            handleReleaseCommand(parts);
            return;
        }

        if ("DUMP".equals(type)) {
            handleDumpCommand();
            return;
        }

        eventLog.add("unknown command: " + line);
    }

    private int parseInt(String value) {
        return Integer.parseInt(value.trim());
    }

    private double parseDouble(String value) {
        return Double.parseDouble(value.trim());
    }

    private int getAvailableStock(String sku) {
        int onHand = stockBySku.getOrDefault(sku, 0);
        int reserved = reservedBySku.getOrDefault(sku, 0);
        return onHand - reserved;
    }

    private void handleRecvCommand(String[] parts) {
        String sku = parts[1];
        int qty = parseInt(parts[2]);
        double unitCost = parseDouble(parts[3]);
        int current = stockBySku.getOrDefault(sku, 0);
        stockBySku.put(sku, current + qty);
        cashBalance = cashBalance - (qty * unitCost);
        eventLog.add("received " + qty + " of " + sku + " at " + unitCost);
    }

    private void handleSellCommand(String[] parts) {
        String customer = parts[1];
        String sku = parts[2];
        int qty = parseInt(parts[3]);
        expireReservations();
        String orderId = "O" + nextOrderNumber;
        nextOrderNumber = nextOrderNumber + 1;

        int available = getAvailableStock(sku);
        if (available < qty) {
            orders.put(orderId, new Order(orderId, sku, qty, OrderStatus.BACKORDER));
            eventLog.add("order " + orderId + " backordered for " + customer + " sku=" + sku + " qty=" + qty);
        } else {
            stockBySku.put(sku, stockBySku.get(sku) - qty);
            double unitPrice = priceBySku.getOrDefault(sku, 0.0);
            double orderTotal = unitPrice * qty;
            cashBalance = cashBalance + orderTotal;
            orders.put(orderId, new Order(orderId, sku, qty, OrderStatus.SHIPPED));
            eventLog.add("order " + orderId + " shipped to " + customer + " amount=" + orderTotal);
        }
    }

    private void handleCancelCommand(String[] parts) {
        String orderId = parts[1];
        Order order = orders.get(orderId);
        if (order == null) {
            eventLog.add("cannot cancel " + orderId + " because it does not exist");
            return;
        }

        if (order.status == OrderStatus.BACKORDER) {
            order.status = OrderStatus.CANCELLED;
            eventLog.add("cancelled backorder " + orderId);
            return;
        }

        if (order.status == OrderStatus.SHIPPED) {
            int current = stockBySku.getOrDefault(order.sku, 0);
            stockBySku.put(order.sku, current + order.qty);
            double unitPrice = priceBySku.getOrDefault(order.sku, 0.0);
            cashBalance = cashBalance - (unitPrice * order.qty);
            order.status = OrderStatus.CANCELLED_AFTER_SHIP;
            eventLog.add("cancelled shipped order " + orderId + " with restock");
            return;
        }

        eventLog.add("order " + orderId + " could not be cancelled from state " + order.status);
    }

    private void handleCountCommand(String[] parts) {
        String sku = parts[1];
        expireReservations();
        int onHand = stockBySku.getOrDefault(sku, 0);
        int reserved = reservedBySku.getOrDefault(sku, 0);
        int available = onHand - reserved;
        eventLog.add("count " + sku + " onHand=" + onHand + " reserved=" + reserved + " available=" + available);
    }

    private void handleReserveCommand(String[] parts) {
        String customer = parts[1];
        String sku = parts[2];
        int qty = parseInt(parts[3]);
        int minutes = parseInt(parts[4]);
        expireReservations();

        int available = getAvailableStock(sku);

        if (available < qty) {
            eventLog.add("cannot reserve " + qty + " of " + sku + " for " + customer + " - only " + available + " available");
            return;
        }

        String reservationId = "R" + nextReservationNumber;
        nextReservationNumber = nextReservationNumber + 1;
        long expiryTime = currentTimeMillis + (minutes * 60L * 1000L);
        reservations.put(reservationId, new Reservation(reservationId, customer, sku, qty, expiryTime));
        reservedBySku.put(sku, reservedBySku.get(sku) + qty);
        eventLog.add("reserved " + qty + " of " + sku + " for " + customer + " as " + reservationId + " expires in " + minutes + " minutes");
    }

    private void handleConfirmCommand(String[] parts) {
        String reservationId = parts[1];
        expireReservations();

        Reservation reservation = reservations.get(reservationId);
        if (reservation == null) {
            eventLog.add("cannot confirm " + reservationId + " - reservation not found or expired");
            return;
        }

        String orderId = "O" + nextOrderNumber;
        nextOrderNumber = nextOrderNumber + 1;

        stockBySku.put(reservation.sku, stockBySku.get(reservation.sku) - reservation.qty);
        reservedBySku.put(reservation.sku, reservedBySku.get(reservation.sku) - reservation.qty);
        reservations.remove(reservationId);

        double unitPrice = priceBySku.getOrDefault(reservation.sku, 0.0);
        double orderTotal = unitPrice * reservation.qty;
        cashBalance = cashBalance + orderTotal;
        orders.put(orderId, new Order(orderId, reservation.sku, reservation.qty, OrderStatus.SHIPPED));
        eventLog.add("order " + orderId + " shipped to " + reservation.customer + " amount=" + orderTotal + " from reservation " + reservationId);
    }

    private void handleReleaseCommand(String[] parts) {
        String reservationId = parts[1];
        expireReservations();

        Reservation reservation = reservations.get(reservationId);
        if (reservation == null) {
            eventLog.add("cannot release " + reservationId + " - reservation not found or expired");
            return;
        }

        reservedBySku.put(reservation.sku, reservedBySku.get(reservation.sku) - reservation.qty);
        reservations.remove(reservationId);
        eventLog.add("released reservation " + reservationId + " for " + reservation.customer + " - " + reservation.qty + " of " + reservation.sku + " returned to available");
    }

    private void handleDumpCommand() {
        System.out.println("---- dump ----");
        System.out.println("stock=" + stockBySku);
        System.out.println("reserved=" + reservedBySku);
        System.out.println("orders=" + orders);
        System.out.println("cashBalance=" + cashBalance);
    }

    private void expireReservations() {
        List<String> toRemove = new ArrayList<>();
        for (Map.Entry<String, Reservation> entry : reservations.entrySet()) {
            if (entry.getValue().expiryTimeMillis <= currentTimeMillis) {
                toRemove.add(entry.getKey());
            }
        }
        for (String id : toRemove) {
            Reservation r = reservations.get(id);
            reservedBySku.put(r.sku, reservedBySku.get(r.sku) - r.qty);
            reservations.remove(id);
            eventLog.add("reservation " + id + " for " + r.customer + " expired - " + r.qty + " of " + r.sku + " returned to available");
        }
    }

    public void setCurrentTimeMillis(long timeMillis) {
        this.currentTimeMillis = timeMillis;
    }

    public void printEndOfDayReport() {
        int shipped = 0;
        int backorder = 0;
        int cancelled = 0;
        for (Order order : orders.values()) {
            if (order.status == OrderStatus.SHIPPED) {
                shipped = shipped + 1;
            } else if (order.status == OrderStatus.BACKORDER) {
                backorder = backorder + 1;
            } else if (order.status == OrderStatus.CANCELLED || order.status == OrderStatus.CANCELLED_AFTER_SHIP) {
                cancelled = cancelled + 1;
            }
        }

        List<String> lowStock = new ArrayList<>();
        for (Map.Entry<String, Integer> item : stockBySku.entrySet()) {
            if (item.getValue() < 5) {
                lowStock.add(item.getKey());
            }
        }

        System.out.println();
        System.out.println("==== end of day ====");
        System.out.println("orders shipped: " + shipped);
        System.out.println("orders backordered: " + backorder);
        System.out.println("orders cancelled: " + cancelled);
        System.out.println("cash balance: " + String.format("%.2f", cashBalance));
        System.out.println("low stock skus: " + lowStock);
        System.out.println();
        System.out.println("events:");
        for (String event : eventLog) {
            System.out.println(" - " + event);
        }
    }

    public List<String> getEventLog() {
        return eventLog;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public double getPrice(String sku) {
        return priceBySku.getOrDefault(sku, 0.0);
    }
}
