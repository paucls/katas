package com.katas.gameoflife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    @Test
    public void calculate_next_generation_of_all_dead_cells_returns_all_dead_cells() throws Exception {
        String initialGeneration = "3 3 " +
                "..." +
                "..." +
                "...";

        String nextGeneration = Game.calculateNextGeneration(initialGeneration);

        assertThat(nextGeneration, is(initialGeneration));
    }

}
