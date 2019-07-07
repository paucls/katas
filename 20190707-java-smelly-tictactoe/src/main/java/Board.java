import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> _plays = new ArrayList<>();

    public Board() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                _plays.add(new Tile(x, y));
            }
        }
    }

    public Tile TileAt(int x, int y) {
        for (Tile tile : _plays) {
            if (tile.x == x && tile.y == y) {
                return tile;
            }
        }
        return null;
    }

    public void AddTileAt(Symbol symbol, int x, int y) {
        TileAt(x, y).symbol = symbol;
    }
}