package com.katas;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TicTacToeAcceptanceTest {

    @Test
    public void player_x_wins() {
        GameOutput output = mock(GameOutput.class);
        GameInput input = mock(GameInput.class);
        when(input.read()).thenReturn("0,0");
        when(input.read()).thenReturn("1,0");
        when(input.read()).thenReturn("0,1");
        when(input.read()).thenReturn("1,1");
        when(input.read()).thenReturn("0,2");

        Game game = new Game(output, input);
        game.start();

        verify(output).print("X placed in 0,0");
        verify(output).print("O placed in 1,0");
        verify(output).print("X placed in 0,1");
        verify(output).print("O placed in 1,1");
        verify(output).print("X placed in 0,2");
        verify(output).print("Player X Wins!");
    }
}
