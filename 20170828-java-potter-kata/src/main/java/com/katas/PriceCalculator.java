package com.katas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class PriceCalculator {

    private static final double BOOK_PRICE = 8.0;
    private static final HashMap<Integer, Double> DISCOUNT_FOR_DIFFERENT_COPIES = new HashMap<Integer, Double>() {{
        put(1, 1.0);
        put(2, 0.95);
        put(3, 0.9);
        put(4, 0.80);
        put(5, 0.75);
    }};

    Double calculate(ShoppingBasket basket) {
        Double total = 0.0;
        Map<String, List<String>> booksGrouped = groupBooks(basket);

//        ArrayList<String> booksPack = extractPack(booksGrouped);
//        if (booksPack.size() > 0) {
//            total += BOOK_PRICE * booksPack.size() * DISCOUNT_FOR_DIFFERENT_COPIES.get(booksPack.size());
//        }

        List<List<String>> packs = extractPacks(booksGrouped);
        for (List<String> pack : packs) {
            if (pack.size() > 0) {
                total += BOOK_PRICE * pack.size() * DISCOUNT_FOR_DIFFERENT_COPIES.get(pack.size());
            }
        }

        int otherBooksCount = booksGrouped.values().stream().mapToInt(List::size).sum();

        total += BOOK_PRICE * otherBooksCount;

        return total;
    }

    private List<List<String>> extractPacks(Map<String, List<String>> booksGrouped) {
        ArrayList<List<String>> packs = new ArrayList<>();

        packs.add(extractPack(booksGrouped));

        return packs;
    }

    private ArrayList<String> extractPack(Map<String, List<String>> booksGrouped) {
        ArrayList<String> booksPack = new ArrayList<>();
        for (String bookTitle : booksGrouped.keySet()) {
            booksPack.add(booksGrouped.get(bookTitle).get(0));
            booksGrouped.get(bookTitle).remove(0);
        }
        return booksPack;
    }

    private Map<String, List<String>> groupBooks(ShoppingBasket basket) {
        return basket.getItems()
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.toList()));
    }
}
