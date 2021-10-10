package com.katas;

public class BowlingGame {
    private int[] rolls;

    public BowlingGame(int[] rolls) {
        this.rolls = rolls;
    }

    public int score() {
        int score = 0;
        for (int rounds = 0; rounds < 10; rounds++) {
            if (rolls[rounds] == 10) {
                score += 10 + rolls[rounds + 1] + rolls[rounds + 2];
            }
            else if (rolls[rounds] + rolls[rounds + 1] == 10) {
                score += 10 + rolls[rounds + 2];
            } else {
                score += rolls[rounds] + rolls[rounds + 1];
            }
        }
        return score;
    }
}
