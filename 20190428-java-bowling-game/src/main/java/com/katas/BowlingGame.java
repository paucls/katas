package com.katas;

import java.util.List;

public class BowlingGame {
    private final List<Integer> rolls;

    public BowlingGame(List<Integer> rolls) {
        this.rolls = rolls;
    }

    public int score() {
        return rolls.stream().reduce(0, Integer::sum);
    }
}
