package it.gabrieletondi.telldontaskkata.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private BigDecimal total;
    private String currency;
    private List<OrderItem> items;
    private BigDecimal tax;
    private OrderStatus status;
    private int id;

    public Order() {
        this.status = OrderStatus.CREATED;
        this.items = new ArrayList<>();
        this.tax = new BigDecimal(0);
        this.total = new BigDecimal(0);
        this.currency = "EUR";
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getCurrency() {
        return currency;
    }

    public List<OrderItem> getItems() {
        return items;
    }
    
    public BigDecimal getTax() {
        return tax;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void ship() {
        this.status = OrderStatus.SHIPPED;
    }

    public void approve() {
        this.status = OrderStatus.APPROVED;
    }

    public void reject() {
        this.status = OrderStatus.REJECTED;
    }

    public void addItem(OrderItem orderItem) {
        this.items.add(orderItem);
        addToTotal(orderItem.getTaxedAmount());
        addToTax(orderItem.getTax());
    }

    private void addToTotal(BigDecimal amount) {
        this.total = this.total.add(amount);
    }

    private void addToTax(BigDecimal amount) {
        this.tax = this.tax.add(amount);
    }
}
