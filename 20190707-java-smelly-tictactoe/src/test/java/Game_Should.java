import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Game_Should {
    private Game game;

    @Before
    public void InitializeGame() {
        game = new Game();
    }

    @Test(expected = Exception.class)
    public void NotAllowPlayerOToPlayFirst() throws Exception {
        game.play(Symbol.O, 0, 0);
    }

    @Test(expected = Exception.class)
    public void NotAllowPlayerXToPlayTwiceInARow() throws Exception {
        game.play(Symbol.X, 0, 0);

        game.play(Symbol.X, 1, 0);
    }

    @Test(expected = Exception.class)
    public void NotAllowPlayerToPlayInLastPlayedPosition() throws Exception {
        game.play(Symbol.X, 0, 0);

        game.play(Symbol.O, 0, 0);
    }

    @Test(expected = Exception.class)
    public void NotAllowPlayerToPlayInAnyPlayedPosition() throws Exception {
        game.play(Symbol.X, 0, 0);
        game.play(Symbol.O, 1, 0);

        game.play(Symbol.X, 0, 0);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception {
        game.play(Symbol.X, 0, 0);
        game.play(Symbol.O, 1, 0);
        game.play(Symbol.X, 0, 1);
        game.play(Symbol.O, 1, 1);
        game.play(Symbol.X, 0, 2);

        Symbol winner = game.winner();

        assertEquals(Symbol.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception {
        game.play(Symbol.X, 2, 2);
        game.play(Symbol.O, 0, 0);
        game.play(Symbol.X, 1, 0);
        game.play(Symbol.O, 0, 1);
        game.play(Symbol.X, 1, 1);
        game.play(Symbol.O, 0, 2);

        Symbol winner = game.winner();

        assertEquals(Symbol.O, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception {
        game.play(Symbol.X, 1, 0);
        game.play(Symbol.O, 0, 0);
        game.play(Symbol.X, 1, 1);
        game.play(Symbol.O, 0, 1);
        game.play(Symbol.X, 1, 2);

        Symbol winner = game.winner();

        assertEquals(Symbol.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception {
        game.play(Symbol.X, 0, 0);
        game.play(Symbol.O, 1, 0);
        game.play(Symbol.X, 2, 0);
        game.play(Symbol.O, 1, 1);
        game.play(Symbol.X, 2, 1);
        game.play(Symbol.O, 1, 2);

        Symbol winner = game.winner();

        assertEquals(Symbol.O, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception {
        game.play(Symbol.X, 2, 0);
        game.play(Symbol.O, 0, 0);
        game.play(Symbol.X, 2, 1);
        game.play(Symbol.O, 0, 1);
        game.play(Symbol.X, 2, 2);

        Symbol winner = game.winner();

        assertEquals(Symbol.X, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception {
        game.play(Symbol.X, 0, 0);
        game.play(Symbol.O, 2, 0);
        game.play(Symbol.X, 1, 0);
        game.play(Symbol.O, 2, 1);
        game.play(Symbol.X, 1, 1);
        game.play(Symbol.O, 2, 2);

        Symbol winner = game.winner();

        assertEquals(Symbol.O, winner);
    }
}
