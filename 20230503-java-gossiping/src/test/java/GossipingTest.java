import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GossipingTest {

    @Test
    void never_when_routes_do_not_intersect() {
        int[][] routes = {
                {1, 2},
                {3, 4}
        };
        Gossiping gossiping = new Gossiping();

        String result = gossiping.howLongItTakes();

        assertThat(result).isEqualTo("never");
    }
}
