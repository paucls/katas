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
        game.Play(Tile.O_SYMBOL, 0, 0);
    }

    @Test(expected = Exception.class)
    public void NotAllowPlayerXToPlayTwiceInARow() throws Exception {
        game.Play(Tile.X_SYMBOL, 0, 0);

        game.Play(Tile.X_SYMBOL, 1, 0);
    }

    @Test(expected = Exception.class)
    public void NotAllowPlayerToPlayInLastPlayedPosition() throws Exception {
        game.Play(Tile.X_SYMBOL, 0, 0);

        game.Play(Tile.O_SYMBOL, 0, 0);
    }

    @Test(expected = Exception.class)
    public void NotAllowPlayerToPlayInAnyPlayedPosition() throws Exception {
        game.Play(Tile.X_SYMBOL, 0, 0);
        game.Play(Tile.O_SYMBOL, 1, 0);

        game.Play(Tile.X_SYMBOL, 0, 0);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInTopRow() throws Exception {
        game.Play(Tile.X_SYMBOL, 0, 0);
        game.Play(Tile.O_SYMBOL, 1, 0);
        game.Play(Tile.X_SYMBOL, 0, 1);
        game.Play(Tile.O_SYMBOL, 1, 1);
        game.Play(Tile.X_SYMBOL, 0, 2);

        char winner = game.Winner();

        assertEquals(Tile.X_SYMBOL, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInTopRow() throws Exception {
        game.Play(Tile.X_SYMBOL, 2, 2);
        game.Play(Tile.O_SYMBOL, 0, 0);
        game.Play(Tile.X_SYMBOL, 1, 0);
        game.Play(Tile.O_SYMBOL, 0, 1);
        game.Play(Tile.X_SYMBOL, 1, 1);
        game.Play(Tile.O_SYMBOL, 0, 2);

        char winner = game.Winner();

        assertEquals(Tile.O_SYMBOL, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInMiddleRow() throws Exception {
        game.Play(Tile.X_SYMBOL, 1, 0);
        game.Play(Tile.O_SYMBOL, 0, 0);
        game.Play(Tile.X_SYMBOL, 1, 1);
        game.Play(Tile.O_SYMBOL, 0, 1);
        game.Play(Tile.X_SYMBOL, 1, 2);

        char winner = game.Winner();

        assertEquals(Tile.X_SYMBOL, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInMiddleRow() throws Exception {
        game.Play(Tile.X_SYMBOL, 0, 0);
        game.Play(Tile.O_SYMBOL, 1, 0);
        game.Play(Tile.X_SYMBOL, 2, 0);
        game.Play(Tile.O_SYMBOL, 1, 1);
        game.Play(Tile.X_SYMBOL, 2, 1);
        game.Play(Tile.O_SYMBOL, 1, 2);

        char winner = game.Winner();

        assertEquals(Tile.O_SYMBOL, winner);
    }

    @Test
    public void DeclarePlayerXAsAWinnerIfThreeInBottomRow() throws Exception {
        game.Play(Tile.X_SYMBOL, 2, 0);
        game.Play(Tile.O_SYMBOL, 0, 0);
        game.Play(Tile.X_SYMBOL, 2, 1);
        game.Play(Tile.O_SYMBOL, 0, 1);
        game.Play(Tile.X_SYMBOL, 2, 2);

        char winner = game.Winner();

        assertEquals(Tile.X_SYMBOL, winner);
    }

    @Test
    public void DeclarePlayerOAsAWinnerIfThreeInBottomRow() throws Exception {
        game.Play(Tile.X_SYMBOL, 0, 0);
        game.Play(Tile.O_SYMBOL, 2, 0);
        game.Play(Tile.X_SYMBOL, 1, 0);
        game.Play(Tile.O_SYMBOL, 2, 1);
        game.Play(Tile.X_SYMBOL, 1, 1);
        game.Play(Tile.O_SYMBOL, 2, 2);

        char winner = game.Winner();

        assertEquals(Tile.O_SYMBOL, winner);
    }
}
