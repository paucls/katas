package com.katas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnitParamsRunner.class)
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

    @Test
    public void is_over_when_all_fields_in_a_diagonal_are_taken_by_a_player() {
        when(board.doYouHaveADiagonalWithAllEquals()).thenReturn(true);

        assertThat(game.isOver()).isTrue();
    }

    @Test
    public void is_over_when_all_fields_in_a_column_are_taken_by_a_player() {
        when(board.doYouHaveAColumnWithAllEquals()).thenReturn(true);

        assertThat(game.isOver()).isTrue();
    }

    @Parameters({"X", "O"})
    @Test
    public void player_can_take_a_position(String playerName) {
        Player player = new Player(playerName);
        Position position = new Position();

        game.play(player, position);

        verify(board).takeField(playerName, position);
    }
}
