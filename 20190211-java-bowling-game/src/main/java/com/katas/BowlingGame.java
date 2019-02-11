package com.katas;

import java.util.ArrayList;

public class BowlingGame {
    private static final int NUM_FRAMES = 10;
    private static final int ALL_PINS_ON_FRAME = 10;

    private final ArrayList<Integer> rolls;

    public BowlingGame(ArrayList<Integer> rolls) {
        this.rolls = rolls;
    }

    public int score() {
        int score = 0;
        int firstRollOnFrame = 0;

        for (int i = 0; i < NUM_FRAMES; i++) {
            if (isStrike(firstRollOnFrame)) {
                score += calculateScoreForStrike(firstRollOnFrame);
                firstRollOnFrame += 1;
            } else if (isSpare(firstRollOnFrame)) {
                score += calculateScoreForSpare(firstRollOnFrame);
                firstRollOnFrame += 2;
            } else {
                score += calculateScoreForTwoRolls(firstRollOnFrame);
                firstRollOnFrame += 2;
            }
        }

        return score;
    }

    private boolean isStrike(int firstRollOnFrame) {
        return rolls.get(firstRollOnFrame) == ALL_PINS_ON_FRAME;
    }

    private boolean isSpare(int firstRollOnFrame) {
        return calculateScoreForTwoRolls(firstRollOnFrame) == ALL_PINS_ON_FRAME;
    }

    private int calculateScoreForTwoRolls(int firstRollOnFrame) {
        return rolls.get(firstRollOnFrame) + rolls.get(firstRollOnFrame + 1);
    }

    private int calculateScoreForStrike(int firstRollOnFrame) {
        return ALL_PINS_ON_FRAME + rolls.get(firstRollOnFrame + 1) + rolls.get(firstRollOnFrame + 2);
    }

    private int calculateScoreForSpare(int firstRollOnFrame) {
        return ALL_PINS_ON_FRAME + rolls.get(firstRollOnFrame + 2);
    }
}
