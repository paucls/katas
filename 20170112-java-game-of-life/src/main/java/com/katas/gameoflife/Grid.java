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

                int nextRow = row + 1;
                int previousRow = row - 1;
                int nextColumn = column + 1;
                int previousColumn = column - 1;

                if (nextRow < rows) {
                    if (grid[nextRow][column]) {
                        aliveNeighbourCount++;
                    }

                    if (nextColumn < columns) {
                        if (grid[nextRow][nextColumn]) {
                            aliveNeighbourCount++;
                        }
                    }
                }

                if (nextColumn < columns) {
                    if (grid[row][nextColumn]) {
                        aliveNeighbourCount++;
                    }
                }

                if (previousRow >= 0) {
                    if (grid[previousRow][column]) {
                        aliveNeighbourCount++;
                    }

                    if (previousColumn >= 0) {
                        if (grid[previousRow][previousColumn]) {
                            aliveNeighbourCount++;
                        }
                    }
                }

                if (previousColumn >= 0) {
                    if (grid[row][previousColumn]) {
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
