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
        assertThat(rover.currentPosition()).isEqualTo(new GridPosition(0, 0));
    }

    @Test
    public void should_indicate_current_facing_direction() {
        assertThat(rover.currentDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void should_move_forward() {
        rover.handleCommand(new char[]{'f'});

        assertThat(rover.currentPosition()).isEqualTo(new GridPosition(0, 1));
    }

    @Test
    public void should_move_forward_multiple_steps() {
        rover.handleCommand(new char[]{'f', 'f', 'f'});

        assertThat(rover.currentPosition()).isEqualTo(new GridPosition(0, 3));
    }

    @Test
    public void should_move_backward() {
        rover.handleCommand(new char[]{'b'});

        assertThat(rover.currentPosition()).isEqualTo(new GridPosition(0, -1));
    }

    @Test
    public void should_turn_left() {
        rover.handleCommand(new char[]{'l'});

        assertThat(rover.currentDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    public void should_turn_right() {
        rover.handleCommand(new char[]{'r'});

        assertThat(rover.currentDirection()).isEqualTo(Direction.EAST);
    }
}
