package com.katas.gameoflife;

public class Game {

    public static final char LIVE_CELL = '*';
    public static final char DEAD_CELL = '.';

    private Board board;

    public Game(String boardDefinition) {
        this.board = BoardParser.parse(boardDefinition);
    }

    public String calculateNextGeneration() {
        for (int row = 0; row < board.getRowsCount(); row++) {
            for (int column = 0; column < board.getColumnsCount(); column++) {
                if (board.getCell(row, column) == LIVE_CELL) {
                    board.setCell(row, column, DEAD_CELL);
                }
            }
        }

        return board.toString();
    }

}
