package com.katas.gameoflife;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GridTest {

    @Test
    public void calculateNextGeneration_when_grid1x1WithDeadCell_then_cellDead() {
        boolean[][] cells = new boolean[1][1];
        cells[0][0] = false;

        Grid grid = new Grid(cells);

        grid.calculateNextGeneration();

        assertThat(grid.get(0, 0), is(false));
    }

    @Test
    public void calculateNextGeneration_when_grid2x2WithAllAliveCells_then_allAlive() {
        boolean[][] cells = new boolean[2][2];
        cells[0][0] = true;
        cells[0][1] = true;
        cells[1][0] = true;
        cells[1][1] = true;

        Grid grid = new Grid(cells);

        grid.calculateNextGeneration();

        assertThat(grid.get(0, 0), is(true));
        assertThat(grid.get(0, 1), is(true));
        assertThat(grid.get(1, 0), is(true));
        assertThat(grid.get(1, 1), is(true));
    }

    @Test
    public void calculateNextGeneration_when_grid2x2WithOneDeadCell_and_threeAliveNeighbours_then_allAlive() {
        boolean[][] cells = new boolean[2][2];
        cells[0][0] = false;
        cells[0][1] = true;
        cells[1][0] = true;
        cells[1][1] = true;

        Grid grid = new Grid(cells);

        grid.calculateNextGeneration();

        assertThat(grid.get(0, 0), is(true));
        assertThat(grid.get(0, 1), is(true));
        assertThat(grid.get(1, 0), is(true));
        assertThat(grid.get(1, 1), is(true));
    }

}
