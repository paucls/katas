package com.katas;

import java.util.HashMap;
import java.util.Map;

class Warehouse {

    Map<String, Integer> stock = new HashMap();

    String receiveBatch(Batch batch) {
        stock.put(batch.title(), batch.count());
        return "SUCCESS";
    }

    int stockCountOf(String title) {
        return stock.get(title);
    }
}
