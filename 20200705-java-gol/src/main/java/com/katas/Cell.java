package com.katas;

import java.util.List;

public class Cell {
    public static final int MIN_SURVIVAL_THRESHOLD = 2;
    public static final int MAX_SURVIVAL_THRESHOLD = 3;
    public static final int REPRODUCTION_NEIGHBOURS_COUNT = 3;
    private List<Cell> neighbours;
    private boolean isAlive = true;

    public Cell() {
    }

    public Cell(List<Cell> neighbours) {
        this.neighbours = neighbours;
    }

    public Cell(List<Cell> neighbours, boolean isAlive) {
        this.neighbours = neighbours;
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void nextGeneration() {
        this.isAlive = isAlive && (neighbours.size() >= MIN_SURVIVAL_THRESHOLD &&
                neighbours.size() <= MAX_SURVIVAL_THRESHOLD)
                || neighbours.size() == REPRODUCTION_NEIGHBOURS_COUNT;
    }
}
