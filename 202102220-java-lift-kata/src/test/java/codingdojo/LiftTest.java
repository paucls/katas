package codingdojo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LiftTest {
    @Test
    public void should_move_up_to_requested_floor() {
        Lift lift = new Lift("A", 0, List.of(1));

        lift.tick();

        assertThat(lift.getFloor()).isOne();
    }

    @Test
    public void should_move_down_to_requested_floor() {
        Lift lift = new Lift("A", 1, List.of(0));

        lift.tick();

        assertThat(lift.getFloor()).isZero();
    }

    @Test
    public void should_open_doors_when_arrives_to_requested_floor() {
        Lift lift = new Lift("A", 0, List.of(0), false);

        lift.tick();

        assertThat(lift.areDoorsOpen()).isTrue();
    }

    @Test
    public void should_close_doors_before_moving_to_requested_floor() {
        Lift lift = new Lift("A", 2, List.of(1, 0), true);

        lift.tick();

        assertThat(lift.areDoorsOpen()).isFalse();
    }

    @Test
    public void should_move_to_the_multiple_requested_floors() {
        Lift lift = new Lift("A", 2, List.of(1, 0));

        lift.tick();
        assertThat(lift.getFloor()).isOne();

        lift.tick();
        lift.tick();
        assertThat(lift.getFloor()).isZero();
    }
}