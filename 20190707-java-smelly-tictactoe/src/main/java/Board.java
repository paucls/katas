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

    public Tile tileAt(int x, int y) {
        for (Tile tile : _plays) {
            if (tile.x == x && tile.y == y) {
                return tile;
            }
        }
        return null;
    }

    public void addTileAt(Symbol symbol, Position position) {
        tileAt(position.x(), position.y()).symbol = symbol;
    }

    boolean isRowTakenWithSameSymbol(int row) {
        return isRowTaken(row) && isRowFullWithSameSymbol(row);
    }

    private boolean isRowTaken(int row) {
        return tileAt(row, 0).isTaken() &&
                tileAt(row, 1).isTaken() &&
                tileAt(row, 2).isTaken();
    }

    private boolean isRowFullWithSameSymbol(int row) {
        return tileAt(row, 0).symbol == tileAt(row, 1).symbol &&
                tileAt(row, 2).symbol == tileAt(row, 1).symbol;
    }
}