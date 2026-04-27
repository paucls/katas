package com.kata.warehouse;

class Reservation {
    final String id;
    final String customer;
    final String sku;
    final int qty;
    final long expiryTimeMillis;

    Reservation(String id, String customer, String sku, int qty, long expiryTimeMillis) {
        this.id = id;
        this.customer = customer;
        this.sku = sku;
        this.qty = qty;
        this.expiryTimeMillis = expiryTimeMillis;
    }
}
