package com.katas;

import java.util.*;

class Basket {

    private static final double BOOK_PRICE = 8.0;

    private static final HashMap<Integer, Double> DISCOUNT_PER_DIFFERENT_BOOKS =
            new HashMap<Integer, Double>() {{
                put(1, 0.00);
                put(2, 0.05);
                put(3, 0.10);
            }};

    private List<String> books;

    Basket(List<String> books) {
        this.books = books;
    }

    double calculateTotal() {
        Double total = books.size() * BOOK_PRICE;

        int differentBooksCount = new HashSet<>(books).size();
        Double discount = DISCOUNT_PER_DIFFERENT_BOOKS.get(differentBooksCount);

        return applyDiscount(total, discount);
    }

    private double applyDiscount(Double amount, Double discount) {
        return amount - amount * discount;
    }

}
