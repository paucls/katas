package com.katas;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardTest {

    private static final String TOKEN_X = "X";
    private static final String TOKEN_O = "O";
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void can_place_token_x_in_position() throws Exception {
        board.place(Token.X, 0, 0);

        assertThat(board.getCell(0, 0)).isEqualTo(TOKEN_X);
    }

    @Test
    public void can_place_token_o_in_position() throws Exception {
        board.place(Token.O, 0, 0);

        assertThat(board.getCell(0, 0)).isEqualTo(TOKEN_O);
    }

    @Test(expected = CannotPlaceInOccupiedPossition.class)
    public void cannot_place_token_in_occupied_position() throws Exception {
        board.place(Token.X, 0, 0);
        board.place(Token.O, 0, 0);

        assertThat(board.getCell(0, 0)).isEqualTo(TOKEN_X);
    }
}
