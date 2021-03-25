package com.katas;

import java.util.List;

public class ShoppingBasket {
    private final List<Item> items;

    public ShoppingBasket(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        double grossValue = items.stream()
                .mapToDouble(Item::getSubTotal)
                .sum();

        if (isSuperDiscount(grossValue)) {
            return applySupperDiscount(grossValue);
        }
        if (isNormalDiscount(grossValue)) {
            return applyNormalDiscount(grossValue);
        }
        return grossValue;
    }

    private boolean isSuperDiscount(double grossValue) {
        return grossValue > 200;
    }

    private double applySupperDiscount(double grossValue) {
        return grossValue - grossValue * 0.10;
    }

    private boolean isNormalDiscount(double grossValue) {
        return grossValue > 100;
    }

    private double applyNormalDiscount(double grossValue) {
        return grossValue - grossValue * 0.05;
    }
}
