package com.katas.gameoflife;

public class Board {

    private char[][] cellsMatrix;

    public Board(int rows, int columns) {
        cellsMatrix = new char[rows][columns];
    }

    public int getRowsCount() {
        return cellsMatrix.length;
    }

    public int getColumnsCount() {
        return cellsMatrix[0].length;
    }

    public char getCell(int row, int column) {
        return cellsMatrix[row][column];
    }

    public void setCell(int row, int column, char cell) {
        cellsMatrix[row][column] = cell;
    }

    @Override
    public String toString() {
        String result = getRowsCount() + " " + getColumnsCount() + " ";

        for (int row = 0; row < getRowsCount(); row++) {
            for (int column = 0; column < getColumnsCount(); column++) {
                result += getCell(row, column);
            }
        }

        return result;
    }
}
