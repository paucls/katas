package kata;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class TennisGameTest {
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
	public void game_returns_null_when_no_winner_yet() {
		assertNull(tennisGame.getWinner());
	}

	@Test
	public void player_scores_point_first_time() {
		tennisGame.playerScores(player1);

		assertEquals(15, player1.getScore());
	}

	@Test
	public void player_scores_winning_point() {
		tennisGame.playerScores(player1);
		tennisGame.playerScores(player1);
		tennisGame.playerScores(player1);
		tennisGame.playerScores(player1);

		assertEquals(tennisGame.getWinner(), player1);
	}

	@Test
	public void should_indicate_when_game_is_in_deuce() {
		tennisGame.playerScores(player1);
		tennisGame.playerScores(player1);
		tennisGame.playerScores(player1);
		assertEquals(40, player1.getScore());

		tennisGame.playerScores(player2);
		tennisGame.playerScores(player2);
		tennisGame.playerScores(player2);
		assertEquals(40, player2.getScore());

		assertTrue(tennisGame.isDeuce());
		assertNull(tennisGame.getWinner());
	}

	@Test
	public void in_a_deuce_a_player_scores_again_but_does_not_win() {
		tennisGame.playerScores(player1);
		tennisGame.playerScores(player1);
		tennisGame.playerScores(player1);

		tennisGame.playerScores(player2);
		tennisGame.playerScores(player2);
		tennisGame.playerScores(player2);

		tennisGame.playerScores(player1);

		assertEquals(player1, tennisGame.getPlayerWithAdvantage());
		assertNull(tennisGame.getWinner());
	}

	@Test
	public void player_in_advantage_scores_and_wins() {
		tennisGame.playerScores(player1);
		tennisGame.playerScores(player1);
		tennisGame.playerScores(player1);

		tennisGame.playerScores(player2);
		tennisGame.playerScores(player2);
		tennisGame.playerScores(player2);

		tennisGame.playerScores(player1);
        tennisGame.playerScores(player1);

        assertEquals(player1, tennisGame.getWinner());
	}

    @Test
    public void first_player_has_advantage_and_second_player_scores() {
        tennisGame.playerScores(player1);
        tennisGame.playerScores(player1);
        tennisGame.playerScores(player1);

        tennisGame.playerScores(player2);
        tennisGame.playerScores(player2);
        tennisGame.playerScores(player2);

        tennisGame.playerScores(player1);
        tennisGame.playerScores(player2);

        assertNull(tennisGame.getPlayerWithAdvantage());
    }

}
