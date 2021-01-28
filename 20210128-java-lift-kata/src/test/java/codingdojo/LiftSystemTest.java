package codingdojo;

import org.junit.jupiter.api.Test;

import static java.util.List.of;
import static org.approvaltests.Approvals.verify;

public class LiftSystemTest {

    @Test
    public void a_lift_should_not_move_when_there_is_no_request_for_it() {
        Lift liftA = new Lift("A", 0);
        LiftSystem lifts = new LiftSystem(of(0, 1), of(liftA), of());
        lifts.tick();
        verifyLifts(lifts);
    }

    @Test
    public void a_lift_should_move_up_to_requested_floor_and_open_doors_in_order_to_fulfill_request() {
        Lift liftA = new Lift("A", 0);
        LiftSystem lifts = new LiftSystem(of(0, 1), of(liftA), of(new Call(1, Direction.DOWN)));
        lifts.tick();
        verifyLifts(lifts);
    }

    @Test
    public void a_lift_should_move_down_to_requested_floor_and_open_doors_in_order_to_fulfill_request() {
        Lift liftA = new Lift("A", 1);
        LiftSystem lifts = new LiftSystem(of(0, 1), of(liftA), of(new Call(0, Direction.UP)));
        lifts.tick();
        verifyLifts(lifts);
    }

    @Test
    void should_not_send_request_to_lift_when_its_doors_are_open() {
        Lift liftA = new Lift("A", 0, true);
        LiftSystem lifts = new LiftSystem(of(0, 1), of(liftA), of(new Call(1, Direction.DOWN)));
        lifts.tick();
        verifyLifts(lifts);
    }

    private void verifyLifts(LiftSystem lifts) {
        verify(new LiftSystemPrinter().print(lifts));
    }
}
