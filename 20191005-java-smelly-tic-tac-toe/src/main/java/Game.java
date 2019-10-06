public class Game {
    public static final char EMPTY_SYMBOL = ' ';
    private char _lastSymbol = EMPTY_SYMBOL;
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == EMPTY_SYMBOL) {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.isPositionTakenAt(x, y)) {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    public char Winner() {
        if (_board.arePositionsTakenAtRow(0)) {
            if (isRowFullWithSameSymbol(0)) {
                return _board.TileAt(0, 0).Symbol;
            }
        }

        if (_board.arePositionsTakenAtRow(1)) {
            if (isRowFullWithSameSymbol(1)) {
                return _board.TileAt(1, 0).Symbol;
            }
        }

        if (_board.arePositionsTakenAtRow(2)) {
            if (isRowFullWithSameSymbol(2)) {
                return _board.TileAt(2, 0).Symbol;
            }
        }

        return EMPTY_SYMBOL;
    }

    private boolean isRowFullWithSameSymbol(int row) {
        return _board.TileAt(row, 0).Symbol ==
                _board.TileAt(row, 1).Symbol &&
                _board.TileAt(row, 2).Symbol == _board.TileAt(row, 1).Symbol;
    }
}

