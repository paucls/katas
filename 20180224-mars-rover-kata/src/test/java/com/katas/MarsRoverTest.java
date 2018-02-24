package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {

    @Test
    public void should_indicate_current_position() {
        MarsRover rover = new MarsRover();

        int[] position = rover.currentPosition();

        assertThat(position).isEqualTo(new int[] {0, 0});
    }

}
