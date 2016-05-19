package kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

	private Player player;

	@Before
	public void setup() {
		player = new Player();
	}

	@Test
	public void player_begins_with_a_score_of_0() {
		assertEquals(0, player.getScore());
	}

	@Test
	public void player_scores_point_first_time() {
		player.scores();

		assertEquals(15, player.getScore());
	}

	@Test
	public void player_scores_point_second_time() {
		player.scores();
		player.scores();

		assertEquals(30, player.getScore());
	}

    @Test
    public void player_scores_point_third_time() {
        player.scores();
        player.scores();
        player.scores();

        assertEquals(40, player.getScore());
    }

}
