package com.katas;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {

    @Test
    public void should_start_prompting_X_player_for_a_move() {
        Prompt prompt = mock(Prompt.class);
        Game game = new Game(prompt);

        game.start();

        verify(prompt).print("Please choose move: ");
    }
}
