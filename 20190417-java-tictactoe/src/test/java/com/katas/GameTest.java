package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    private final Board board = mock(Board.class);
    private final Game game = new Game(board);

    @Test
    public void is_not_over_when_fields_available() {
        assertThat(game.isOver()).isFalse();
    }

    @Test
    public void is_over_when_all_fields_are_taken() {
        when(board.allFieldsTaken()).thenReturn(true);

        assertThat(game.isOver()).isTrue();
    }

    @Test
    public void is_over_when_all_fields_in_a_row_are_taken_by_a_player() {
        when(board.doYouHaveARowWithAllEquals()).thenReturn(true);

        assertThat(game.isOver()).isTrue();
    }
}
