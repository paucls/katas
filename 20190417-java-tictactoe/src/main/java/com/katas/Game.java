package com.katas;

public class Game {
    Board board;

    public Game(Board board) {
        this.board = board;
    }

    public boolean isOver() {
        return board.allFieldsTaken() ||
                board.doYouHaveARowWithAllEquals() ||
                board.doYouHaveADiagonalWithAllEquals();
    }
}
