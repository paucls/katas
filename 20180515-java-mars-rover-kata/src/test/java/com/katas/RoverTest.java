package com.katas;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    @Test
    public void should_report_position() {
        Rover rover = new Rover();

        assertThat(rover.reportPosition()).isEqualTo("0:0:N");
    }

    @Test
    public void should_turn_left() {
        Rover rover = new Rover();

        rover.execute("L");

        assertThat(rover.reportPosition()).isEqualTo("0:0:W");
    }

    @Test
    public void should_turn_left_multiple_times() {
        Rover rover = new Rover();

        rover.execute("L");
        assertThat(rover.reportPosition()).isEqualTo("0:0:W");
        rover.execute("L");
        assertThat(rover.reportPosition()).isEqualTo("0:0:S");
        rover.execute("L");
        assertThat(rover.reportPosition()).isEqualTo("0:0:E");
        rover.execute("L");
        assertThat(rover.reportPosition()).isEqualTo("0:0:N");
    }

    @Test
    public void should_turn_right_one_time() {
        Rover rover = new Rover();

        rover.execute("R");

        assertThat(rover.reportPosition()).isEqualTo("0:0:E");
    }

    @Test
    public void should_turn_right_multiple_times() {
        Rover rover = new Rover();

        rover.execute("R");
        assertThat(rover.reportPosition()).isEqualTo("0:0:E");
        rover.execute("R");
        assertThat(rover.reportPosition()).isEqualTo("0:0:S");
        rover.execute("R");
        assertThat(rover.reportPosition()).isEqualTo("0:0:W");
        rover.execute("R");
        assertThat(rover.reportPosition()).isEqualTo("0:0:N");
    }
}
