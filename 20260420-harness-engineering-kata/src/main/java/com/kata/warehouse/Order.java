package com.kata.warehouse;

public class Order {
    final String id;
    final String sku;
    final int qty;
    OrderStatus status;

    Order(String id, String sku, int qty, OrderStatus status) {
        this.id = id;
        this.sku = sku;
        this.qty = qty;
        this.status = status;
    }
}
