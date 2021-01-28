package codingdojo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.approvaltests.Approvals.verify;

public class LiftSystemTest {

    @Test
    public void a_lift_should_not_move_when_there_is_no_request_for_it() {
        Lift liftA = new Lift("A", 0);
        LiftSystem lifts = new LiftSystem(Arrays.asList(0, 1), Collections.singletonList(liftA), Collections.emptyList());
        lifts.tick();
        verify(new LiftSystemPrinter().print(lifts));
    }

    @Test
    public void a_lift_should_move_to_requested_floor_and_open_doors_in_order_to_fulfill_request() {
        Lift liftA = new Lift("A", 0);
        LiftSystem lifts = new LiftSystem(Arrays.asList(0, 1),
                Collections.singletonList(liftA),
                Collections.singletonList(new Call(1, Direction.DOWN)));
        lifts.tick();
        verify(new LiftSystemPrinter().print(lifts));
    }
}
