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
        Gossiping gossiping = new Gossiping(routes);

        String result = gossiping.howLongItTakes();

        assertThat(result).isEqualTo("never");
    }

    @Test
    void takes_one_stop_when_routes_intersect_in_first_stop() {
        int[][] routes = {
                {1, 2},
                {1, 3}
        };
        Gossiping gossiping = new Gossiping(routes);

        String result = gossiping.howLongItTakes();

        assertThat(result).isEqualTo("1");
    }

    @Test
    void takes_two_stops_when_routes_intersect_in_second_stop() {
        int[][] routes = {
                {2, 1},
                {3, 1}
        };
        Gossiping gossiping = new Gossiping(routes);

        String result = gossiping.howLongItTakes();

        assertThat(result).isEqualTo("2");
    }

    @Test
    void calculates_how_long_it_task_when_multiple_drivers() {
        int[][] routes = {
                {1, 2},
                {1, 3},
                {1, 4},
        };
        Gossiping gossiping = new Gossiping(routes);

        String result = gossiping.howLongItTakes();

        assertThat(result).isEqualTo("1");
    }
}
