package codingdojo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class LiftSystemTest {

    // TODO: finish writing this test
    @Test
    public void doSomething() {
        Lift liftA = new Lift("A", 0);
        LiftSystem lifts = new LiftSystem(Arrays.asList(0, 1), Collections.singletonList(liftA), Collections.emptyList());

        lifts.tick();

    }
}
