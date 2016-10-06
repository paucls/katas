package com.katas.gameoflife;

import org.junit.Ignore;
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
        Game game = new Game(initialGeneration);

        String nextGeneration = game.calculateNextGeneration();

        assertThat(nextGeneration, is(initialGeneration));
    }

    @Test
    public void any_live_cell_with_fewer_than_two_live_neighbours_dies() {
        String initialGeneration = "3 3 " +
                ".**" +
                "..." +
                "...";
        Game game = new Game(initialGeneration);

        String nextGeneration = game.calculateNextGeneration();

        assertThat(nextGeneration, is("3 3 " +
                "..." +
                "..." +
                "..."));
    }

    @Test
    @Ignore
    public void any_live_cell_with_two_or_three_live_neighbours_lives() {
        String initialGeneration = "3 3 " +
                "***" +
                "..." +
                "...";
        Game game = new Game(initialGeneration);

        String nextGeneration = game.calculateNextGeneration();

        assertThat(nextGeneration, is("3 3 " +
                ".*." +
                "..." +
                "..."));
    }

}
