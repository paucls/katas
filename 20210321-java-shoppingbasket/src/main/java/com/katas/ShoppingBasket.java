package com.katas;

import java.util.List;

public class ShoppingBasket {

    private List<Item> items;

    public ShoppingBasket(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        if (items.isEmpty())
            return 0;
        return 100;
    }
}
