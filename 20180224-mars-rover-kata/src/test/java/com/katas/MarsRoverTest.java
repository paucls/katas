package com.katas;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {

    MarsRover rover;

    @Before
    public void setUp() {
        rover = new MarsRover();
    }

    @Test
    public void should_indicate_current_position() {
        int[] position = rover.currentPosition();

        assertThat(position).isEqualTo(new int[]{0, 0});
    }

    @Test
    public void should_move_forward() {
        rover.handleCommand(new char[]{'f'});

        assertThat(rover.currentPosition()).isEqualTo(new int[]{0, 1});
    }

    @Test
    public void should_move_forward_multiple_steps() {
        rover.handleCommand(new char[]{'f', 'f', 'f'});

        assertThat(rover.currentPosition()).isEqualTo(new int[]{0, 3});
    }
}
