package com.katas.gameoflife;

public abstract class BoardParser {

    public static Board parse(String boardDefinition) {

        String[] tokens = boardDefinition.split(" ");

        int rows = Integer.valueOf(tokens[0]);
        int columns = Integer.valueOf(tokens[1]);
        String board = tokens[2];

        Board myBoard = new Board(rows, columns);

        int cellNumber = 0;
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                myBoard.setCell(i, j, board.charAt(cellNumber));
                cellNumber++;
            }
        }

        return myBoard;
    }
}
