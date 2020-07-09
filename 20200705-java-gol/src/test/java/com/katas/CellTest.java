package com.katas;

import org.assertj.core.internal.bytebuddy.agent.builder.AgentBuilder;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;

public class CellTest {
    @Test
    public void should_die_when_has_less_than_2_neighbours() {
        List<Cell> neighbours = of(aCell());
        Cell cell = new Cell(neighbours);

        cell.nextGeneration();

        assertThat(cell.isAlive()).isFalse();
    }

    @Test
    public void should_survive_when_has_2_neighbours() {
        List<Cell> neighbours = of(aCell(), aCell());
        Cell cell = new Cell(neighbours);

        cell.nextGeneration();

        assertThat(cell.isAlive()).isTrue();
    }

    @Test
    public void should_die_when_has_more_than_3_neighbours() {
        List<Cell> neighbours = of(aCell(), aCell(), aCell(), aCell());
        Cell cell = new Cell(neighbours);

        cell.nextGeneration();

        assertThat(cell.isAlive()).isFalse();
    }

    @Test
    public void should_become_alive_when_dead_and_has_exactly_3_neighbours() {
        List<Cell> neighbours = of(aCell(), aCell(), aCell());
        Cell cell = new Cell(neighbours, false);

        cell.nextGeneration();

        assertThat(cell.isAlive()).isTrue();
    }

    @Test
    public void should_remain_dead_when_dead_and_has_2_neighbours() {
        List<Cell> neighbours = of(aCell(), aCell());
        Cell cell = new Cell(neighbours, false);

        cell.nextGeneration();

        assertThat(cell.isAlive()).isFalse();
    }

    private Cell aCell() {
        return new Cell();
    }
}
