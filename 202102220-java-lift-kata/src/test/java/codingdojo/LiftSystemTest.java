package codingdojo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LiftSystemTest {

    @Test
    public void lift_should_move_up_to_requested_floor() {
        Lift liftA = new Lift("A", 0, asList(1));
        LiftSystem lifts = new LiftSystem(asList(0, 1), asList(liftA), asList());

        lifts.tick();

        Lift lift = lifts.getLifts().get(0);
        assertThat(lift.getFloor()).isOne();
    }

    @Test
    public void lift_should_move_down_to_requested_floor() {
        Lift liftA = new Lift("A", 1, asList(0));
        LiftSystem lifts = new LiftSystem(asList(0, 1), asList(liftA), asList());

        lifts.tick();

        Lift lift = lifts.getLifts().get(0);
        assertThat(lift.getFloor()).isZero();
    }

    @Test
    public void lift_should_open_door_when_arrives_to_requested_floor() {
        Lift liftA = new Lift("A", 0, asList(0));
        LiftSystem lifts = new LiftSystem(asList(0, 1), asList(liftA), asList());

        lifts.tick();

        Lift lift = lifts.getLifts().get(0);
        assertThat(lift.areDoorsOpen()).isTrue();
    }
}
