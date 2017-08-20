package com.katas;

import java.util.List;

class Basket {

    private static final double BOOK_PRICE = 8.0;

    private List<String> books;

    Basket(List<String> books) {
        this.books = books;
    }

    double calculateTotal() {
        return books.size() * BOOK_PRICE;
    }

}
