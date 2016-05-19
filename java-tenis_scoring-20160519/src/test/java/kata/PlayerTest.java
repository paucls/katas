package kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

	private Player player1;
	private Player player2;
	private TennisGame tennisGame;

	@Before
	public void setup() {
		player1 = new Player();
		player2 = new Player();
		tennisGame = new TennisGame(player1, player2);
	}

	@Test
	public void player_begins_with_a_score_of_0() {
		assertEquals(0, player1.getScore());
	}

	@Test
	public void player_scores_point_first_time() {
		player1.scores();

		assertEquals(15, player1.getScore());
	}

	@Test
	public void player_scores_point_second_time() {
		player1.scores();
		player1.scores();

		assertEquals(30, player1.getScore());
	}

	@Test
	public void player_scores_point_third_time() {
		player1.scores();
		player1.scores();
		player1.scores();

		assertEquals(40, player1.getScore());
	}

	@Test
	public void player_scores_winning_point() {
		player1.scores();
		player1.scores();
		player1.scores();
		player1.scores();

		assertEquals(tennisGame.getWinner(), player1);
	}

	@Test
	public void second_player_scores_winning_point() {
		player2.scores();
		player2.scores();
		player2.scores();
		player2.scores();

		assertEquals(tennisGame.getWinner(), player2);
	}

}
