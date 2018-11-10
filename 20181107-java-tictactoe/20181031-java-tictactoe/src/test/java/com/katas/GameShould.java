package com.katas;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameShould {

    private GameOutput output;
    private GameInput input;
    private Game game;

    @Before
    public void setUp() {
        output = mock(GameOutput.class);
        input = mock(GameInput.class);
        game = new Game(output, input);
    }

    @Test
    public void take_player_x_move_in_00() {
        when(input.read())
                .thenReturn("0,0")
                .thenReturn(null);

        game.start();

        verify(output).print("X placed in 0,0");
    }

    @Test
    public void take_player_x_move_in_10() {
        when(input.read())
                .thenReturn("1,0")
                .thenReturn(null);

        game.start();

        verify(output).print("X placed in 1,0");
    }

    @Test
    public void take_player_0_move_in_10() {
        when(input.read())
                .thenReturn("0,0")
                .thenReturn("1,0")
                .thenReturn(null);

        game.start();

        verify(output).print("X placed in 0,0");
        verify(output).print("O placed in 1,0");
    }

    @Test
    public void end_when_player_x_wins() {
        when(input.read())
                .thenReturn("0,0")
                .thenReturn("1,0")
                .thenReturn("0,1")
                .thenReturn("1,1")
                .thenReturn("0,2");

        game.start();

        verify(output).print("Player X Wins!");
    }

    @Test
    public void end_when_player_x_wins_with_column() {
        when(input.read())
                .thenReturn("0,0")
                .thenReturn("0,1")
                .thenReturn("1,0")
                .thenReturn("1,2")
                .thenReturn("2,0");

        game.start();

        verify(output).print("Player X Wins!");
    }

    @Test
    public void not_end_when_player_x_still_has_move_left() {
        when(input.read())
                .thenReturn("0,0")
                .thenReturn("1,0")
                .thenReturn("0,1")
                .thenReturn("1,1")
                .thenReturn(null);

        game.start();

        verify(output, never()).print("Player X Wins!");
        verify(output, never()).print("Player Y Wins!");
    }
}
