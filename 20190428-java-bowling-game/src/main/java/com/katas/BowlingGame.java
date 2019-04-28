package com.katas;

import java.util.List;

public class BowlingGame {
    private static final int NUM_FRAMES = 10;

    private final List<Integer> rolls;

    public BowlingGame(List<Integer> rolls) {
        this.rolls = rolls;
    }

    public int score() {
        int result = 0;
        int rollIndex = 0;

        for (int i = 0; i < NUM_FRAMES; i++) {
            if (rolls.get(rollIndex) == 10) {
                result += 10 + rolls.get(rollIndex + 1) + rolls.get(rollIndex + 2);
                rollIndex++;
                continue;
            }

            int frameScore = rolls.get(rollIndex) + rolls.get(rollIndex + 1);
            result += frameScore;
            if (frameScore == 10) result += rolls.get(rollIndex + 2);
            rollIndex += 2;
        }

        return result;
    }
}
