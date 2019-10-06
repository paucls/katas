import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> _plays = new ArrayList<>();

    public Board() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                Tile tile = new Tile(new Position(row, column));
                _plays.add(tile);
            }
        }
    }

    public Tile TileAt(int x, int y) {
        for (Tile tile : _plays) {
            if (tile.X == x && tile.Y == y) {
                return tile;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, int x, int y) throws Exception {
        if (isPositionTakenAt(x, y)) {
            throw new Exception("Invalid position");
        }

        TileAt(x, y).Symbol = symbol;
    }

    boolean arePositionsTakenAtRow(int row) {
        return isPositionTakenAt(row, 0) &&
                isPositionTakenAt(row, 1) &&
                isPositionTakenAt(row, 2);
    }

    boolean isPositionTakenAt(int x, int y) {
        return TileAt(x, y).Symbol != Game.EMPTY_SYMBOL;
    }

    boolean isRowFullWithSameSymbol(int row) {
        return TileAt(row, 0).Symbol ==
                TileAt(row, 1).Symbol &&
                TileAt(row, 2).Symbol == TileAt(row, 1).Symbol;
    }
}