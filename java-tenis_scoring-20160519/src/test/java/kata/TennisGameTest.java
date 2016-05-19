package kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by estebp on 5/19/16.
 */
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
