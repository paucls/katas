package com.katas;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Basket {

    private static final double BOOK_PRICE = 8.0;
    private static final double DISCOUNT_2_BOOKS = 0.05;

    private List<String> books;

    Basket(List<String> books) {
        this.books = books;
    }

    double calculateTotal() {
        Set<String> differentBooks = new HashSet<>(books);

        Double total = books.size() * BOOK_PRICE;

        if (differentBooks.size() == 2) {
            return applyDiscount(total, DISCOUNT_2_BOOKS);
        }

        return total;
    }

    private double applyDiscount(Double amount, Double discount) {
        return amount - amount * discount;
    }

}
