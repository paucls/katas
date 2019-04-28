package com.katas;

import java.util.List;

public class BowlingGame {
    private final List<Integer> rolls;

    public BowlingGame(List<Integer> rolls) {
        this.rolls = rolls;
    }

    public int score() {
        int result = 0;

        for (int i = 0; i < rolls.size(); i++) {
            result += rolls.get(i);
        }

        return result;
    }
}
