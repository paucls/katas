public class Game {
    private char _lastSymbol = Tile.EMPTY_SYMBOL;
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == Tile.EMPTY_SYMBOL) {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }

        // update game state
        _board.AddTileAt(symbol, x, y);
        _lastSymbol = symbol;
    }

    public char Winner() {
        if (_board.arePositionsTakenAtRow(0)) {
            if (_board.isRowFullWithSameSymbol(0)) {
                return _lastSymbol;
            }
        }

        if (_board.arePositionsTakenAtRow(1)) {
            if (_board.isRowFullWithSameSymbol(1)) {
                return _lastSymbol;
            }
        }

        if (_board.arePositionsTakenAtRow(2)) {
            if (_board.isRowFullWithSameSymbol(2)) {
                return _lastSymbol;
            }
        }

        return Tile.EMPTY_SYMBOL;
    }
}

