package com.katas;

import java.util.List;

public class BowlingGame {
    private static final int ALL_PINS = 10;
    private static final int NUM_FRAMES = 10;

    private final List<Integer> rolls;

    public BowlingGame(List<Integer> rolls) {
        this.rolls = rolls;
    }

    public int score() {
        int result = 0;
        int firstInFrame = 0;

        for (int i = 0; i < NUM_FRAMES; i++) {
            if (isStrike(firstInFrame)) {
                result += calculateStrike(firstInFrame);
                firstInFrame += 1;
            } else if (isSpare(firstInFrame)) {
                result += calculateSpare(firstInFrame);
                firstInFrame += 2;
            } else {
                result += calculateSimple(firstInFrame);
                firstInFrame += 2;
            }
        }

        return result;
    }

    private boolean isStrike(int firstInFrame) {
        return rolls.get(firstInFrame) == ALL_PINS;
    }

    private int calculateStrike(int firstInFrame) {
        return ALL_PINS + rolls.get(firstInFrame + 1) + rolls.get(firstInFrame + 2);
    }

    private boolean isSpare(int firstInFrame) {
        return rolls.get(firstInFrame) + rolls.get(firstInFrame + 1) == ALL_PINS;
    }

    private int calculateSpare(int firstInFrame) {
        return ALL_PINS + rolls.get(firstInFrame + 2);
    }

    private int calculateSimple(int firstInFrame) {
        return rolls.get(firstInFrame) + rolls.get(firstInFrame + 1);
    }
}
