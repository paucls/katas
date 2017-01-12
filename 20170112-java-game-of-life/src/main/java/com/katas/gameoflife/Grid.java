package com.katas.gameoflife;

public class Grid {
    private boolean[][] grid;
    private int columns;
    private int rows;

    public Grid(boolean[][] gridCells) {
        grid = gridCells;

        columns = grid[0].length;
        rows = grid.length;
    }

    public void calculateNextGeneration() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column]) {
                    continue;
                }

                int aliveNeighbourCount = 0;

                if (row + 1 < rows) {
                    if (grid[row + 1][column]) {
                        aliveNeighbourCount++;
                    }

                    if (column + 1 < columns) {
                        if (grid[row + 1][column + 1]) {
                            aliveNeighbourCount++;
                        }
                    }
                }

                if (column + 1 < columns) {
                    if (grid[row][column + 1]) {
                        aliveNeighbourCount++;
                    }
                }

                if (aliveNeighbourCount >= 3) {
                    grid[row][column] = true;
                }
            }
        }
    }

    public boolean get(int x, int y) {
        return grid[x][y];
    }

}
