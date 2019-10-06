import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tile> _plays = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile(new Position(i, j));
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

    public void AddTileAt(char symbol, int x, int y) {
        TileAt(x, y).Symbol = symbol;
    }

    boolean arePositionsTakenAtRow(int index) {
        return isPositionTakenAt(index, 0) &&
                isPositionTakenAt(index, 1) &&
                isPositionTakenAt(index, 2);
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