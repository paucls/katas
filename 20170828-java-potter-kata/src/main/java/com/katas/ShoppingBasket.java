package com.katas;

import java.util.List;

class ShoppingBasket {
    private List<String> items;

    ShoppingBasket(List<String> items) {
        this.items = items;
    }

    int itemsCount() {
        return items.size();
    }

    public List<String> getItems() {
        return items;
    }
}
