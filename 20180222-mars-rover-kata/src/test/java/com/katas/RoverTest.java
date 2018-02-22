package com.katas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoverTest {

    @Test
    public void should_initialise_to_given_position() {
        Rover rover = new Rover(new Position(1, 1));

        assertThat(rover.getPosition(), is(new Position(1, 1)));
    }

    @Test
    public void moveForward_should_move_one_step_forward() {
        Rover rover = new Rover(new Position(0, 0));

        rover.moveForward();

        assertThat(rover.getPosition(), is(new Position(0, 1)));
    }

    @Test
    public void moveBackward_should_move_one_step_backward() {
        Rover rover = new Rover(new Position(0, 1));

        rover.moveBackward();

        assertThat(rover.getPosition(), is(new Position(0, 0)));
    }

}