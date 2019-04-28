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
            if (rolls.get(firstInFrame) == ALL_PINS) {
                result += ALL_PINS + rolls.get(firstInFrame + 1) + rolls.get(firstInFrame + 2);
                firstInFrame++;
            } else if (rolls.get(firstInFrame) + rolls.get(firstInFrame + 1) == ALL_PINS) {
                result += ALL_PINS + rolls.get(firstInFrame + 2);
                firstInFrame += 2;
            } else {
                result += rolls.get(firstInFrame) + rolls.get(firstInFrame + 1);
                firstInFrame += 2;
            }
        }

        return result;
    }
}
