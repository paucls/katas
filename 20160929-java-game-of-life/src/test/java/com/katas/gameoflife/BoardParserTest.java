package com.katas.gameoflife;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class BoardParserTest {

    @Test
    public void parse_a_string_representing_a_1x1_board_returns_a_board(){
       String boardString = "1 1 *";

        Board myBoard = BoardParser.parse(boardString);

        assertThat(myBoard.getRowsCount(), is(1));
        assertThat(myBoard.getColumnsCount(), is(1));
    }

    @Test
    public void parse_a_string_representing_a_2x3_board_with_cells_returns_a_board() {
        String boardString = "2 3 " +
                "..." +
                "*..";

        Board myBoard = BoardParser.parse(boardString);

        assertThat(myBoard.getRowsCount(), is(2));
        assertThat(myBoard.getColumnsCount(), is(3));
        assertThat(myBoard.getCell(0, 0), is('.'));
        assertThat(myBoard.getCell(0, 0), is('.'));
        assertThat(myBoard.getCell(0, 0), is('.'));
        assertThat(myBoard.getCell(1, 0), is('*'));
        assertThat(myBoard.getCell(1, 1), is('.'));
        assertThat(myBoard.getCell(1, 2), is('.'));
    }
}
