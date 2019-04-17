package com.katas;

public class Game {
    Board board;

    public Game(Board board) {
        this.board = board;
    }

    public boolean isOver() {
        return board.allFieldsTaken() ||
                board.doYouHaveARowWithAllEquals() ||
                board.doYouHaveADiagonalWithAllEquals() ||
                board.doYouHaveAColumnWithAllEquals();
    }

    public void play(Player player, Position position) {
        board.takeField(player.name(), position);
    }
}
