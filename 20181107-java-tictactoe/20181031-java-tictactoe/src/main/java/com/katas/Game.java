package com.katas;

class Game {

    private final GameOutput output;
    private final GameInput input;
    private int movesCount = 0;

    Game(GameOutput output, GameInput input) {
        this.output = output;
        this.input = input;
    }

    void start() {
        String position = read();

        while (position != null && movesCount != 5) {
            if (movesCount % 2 == 0) {
                output.print("X placed in " + position);
            } else {
                output.print("O placed in 1,0");
            }
            movesCount++;

            position = read();
        }

        if (movesCount == 5) {
            output.print("Player X Wins!");
        }
    }

    private String read() {
        return input.read();
    }
}
