package com.kata.warehouse;

public enum OrderStatus {
    SHIPPED,
    BACKORDER,
    CANCELLED,
    CANCELLED_AFTER_SHIP;

    @Override
    public String toString() {
        return name();
    }
}
