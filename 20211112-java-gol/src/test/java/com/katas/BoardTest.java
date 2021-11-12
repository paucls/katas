package com.katas;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardTest {

    private final Board board = new Board();

    @Test
    public void a_new_board_should_be_empty() {
        assertThat(board.isEmpty()).isTrue();
    }

    @Test
    public void a_board_should_not_be_empty_after_setting_initial_pattern() {
        board.setAliveAt(1, 2);

        assertThat(board.isEmpty()).isFalse();
    }

    @Test
    public void a_board_should_set_alive_cells_when_setting_initial_pattern() {
        board.setAliveAt(1, 2);
        board.setAliveAt(2, 1);

        assertThat(board.isAliveAt(1, 2)).isTrue();
        assertThat(board.isAliveAt(2, 1)).isTrue();
    }
}
