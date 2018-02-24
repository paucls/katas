package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void should_return_next_direction_on_the_left() {
        assertThat(Direction.NORTH.left()).isEqualTo(Direction.WEST);
        assertThat(Direction.WEST.left()).isEqualTo(Direction.SOUTH);
        assertThat(Direction.SOUTH.left()).isEqualTo(Direction.EAST);
        assertThat(Direction.EAST.left()).isEqualTo(Direction.NORTH);
    }

    @Test
    public void should_return_next_direction_on_the_right() {
        assertThat(Direction.NORTH.right()).isEqualTo(Direction.EAST);
        assertThat(Direction.EAST.right()).isEqualTo(Direction.SOUTH);
        assertThat(Direction.SOUTH.right()).isEqualTo(Direction.WEST);
        assertThat(Direction.WEST.right()).isEqualTo(Direction.NORTH);
    }

}