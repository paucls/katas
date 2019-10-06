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

    private Tile TileAt(int x, int y) {
        for (Tile tile : _plays) {
            if (tile.X == x && tile.Y == y) {
                return tile;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, Position position) throws Exception {
        if (TileAt(position.x(), position.y()).isTaken()) {
            throw new Exception("Invalid position");
        }

        TileAt(position.x(), position.y()).Symbol = symbol;
    }

    boolean arePositionsTakenAtRow(int row) {
        return TileAt(row, 0).isTaken() &&
                TileAt(row, 1).isTaken() &&
                TileAt(row, 2).isTaken();
    }

    boolean isRowFullWithSameSymbol(int row) {
        return TileAt(row, 0).Symbol ==
                TileAt(row, 1).Symbol &&
                TileAt(row, 2).Symbol == TileAt(row, 1).Symbol;
    }
}