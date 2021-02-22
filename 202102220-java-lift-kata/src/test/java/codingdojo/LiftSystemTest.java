package codingdojo;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LiftSystemTest {

    @Test
    public void lift_should_move_up_to_requested_floor() {
        Lift liftA = new Lift("A", 0, asList(1));
        LiftSystem liftSystem = aLiftSystem(liftA);

        liftSystem.tick();

        Lift lift = liftSystem.getLifts().get(0);
        assertThat(lift.getFloor()).isOne();
    }

    @Test
    public void lift_should_move_down_to_requested_floor() {
        Lift liftA = new Lift("A", 1, asList(0));
        LiftSystem liftSystem = aLiftSystem(liftA);

        liftSystem.tick();

        Lift lift = liftSystem.getLifts().get(0);
        assertThat(lift.getFloor()).isZero();
    }

    @Test
    public void lift_should_open_door_when_arrives_to_requested_floor() {
        Lift liftA = new Lift("A", 0, asList(0));
        LiftSystem liftSystem = aLiftSystem(liftA);

        liftSystem.tick();

        Lift lift = liftSystem.getLifts().get(0);
        assertThat(lift.areDoorsOpen()).isTrue();
    }

    @Test
    public void lift_should_move_to_the_multiple_requested_floors() {
        Lift liftA = new Lift("A", 2, asList(1, 0));
        LiftSystem liftSystem = aLiftSystem(liftA);

        liftSystem.tick();
        Lift lift = liftSystem.getLifts().get(0);
        assertThat(lift.getFloor()).isOne();

        liftSystem.tick();
        assertThat(lift.getFloor()).isZero();
    }

    private LiftSystem aLiftSystem(Lift liftA) {
        return new LiftSystem(asList(0, 1, 2), asList(liftA), asList());
    }
}
