package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    @Test
    public void should_report_position() {
        Rover rover = new Rover();

        assertThat(rover.reportPosition()).isEqualTo("0:0:N");
    }

}
