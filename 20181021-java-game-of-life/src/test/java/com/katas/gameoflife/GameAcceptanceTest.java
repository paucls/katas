package com.katas.gameoflife;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameAcceptanceTest {

    @Test
    public void should_calculate_next_generation() {
        Game game = new Game();
        int[][] cells = new int[][]{
                {1, 0, 0},
                {0, 0, 1},
                {0, 1, 1}
        };
        Grid current = new Grid(cells);

        Grid next = game.calculateNext(current);

        assertThat(next, is(new Grid(new int[][]{
                {0, 0, 0},
                {0, 0, 1},
                {0, 1, 1}
        })));
    }

}
