package com.katas.gameoflife;

public class Game {

    public static final String LIVE_CELL = "*";
    public static final String DEAD_CELL = ".";

    public static String calculateNextGeneration(String generation) {
        if (generation.contains(LIVE_CELL)) {
            return generation.replace(LIVE_CELL, DEAD_CELL);
        }

        return generation;
    }

}
