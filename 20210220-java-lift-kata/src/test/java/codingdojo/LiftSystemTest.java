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

    private LiftSystem aLiftSystem(Lift liftA) {
        return new LiftSystem(asList(0, 1, 2), asList(liftA), asList());
    }
}
