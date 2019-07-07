public class Game {
    private Symbol _lastSymbol = Symbol.EMPTY;
    private Board _board = new Board();

    public void Play(Symbol symbol, int x, int y) throws Exception {
        //if first move
        if (_lastSymbol == Symbol.EMPTY) {
            //if player is x
            if (symbol == Symbol.O) {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (_board.TileAt(x, y).isTaken()) {
            throw new Exception("Invalid position");
        }

        // update game state
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    public Symbol Winner() {
        //if the positions in first row are taken
        if (_board.TileAt(0, 0).isTaken() &&
                _board.TileAt(0, 1).isTaken() &&
                _board.TileAt(0, 2).isTaken()) {
            //if first row is full with same symbol
            if (_board.TileAt(0, 0).symbol ==
                    _board.TileAt(0, 1).symbol &&
                    _board.TileAt(0, 2).symbol == _board.TileAt(0, 1).symbol) {
                return _board.TileAt(0, 0).symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(1, 0).isTaken() &&
                _board.TileAt(1, 1).isTaken() &&
                _board.TileAt(1, 2).isTaken()) {
            //if middle row is full with same symbol
            if (_board.TileAt(1, 0).symbol ==
                    _board.TileAt(1, 1).symbol &&
                    _board.TileAt(1, 2).symbol ==
                            _board.TileAt(1, 1).symbol) {
                return _board.TileAt(1, 0).symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.TileAt(2, 0).isTaken() &&
                _board.TileAt(2, 1).isTaken() &&
                _board.TileAt(2, 2).isTaken()) {
            //if middle row is full with same symbol
            if (_board.TileAt(2, 0).symbol ==
                    _board.TileAt(2, 1).symbol &&
                    _board.TileAt(2, 2).symbol ==
                            _board.TileAt(2, 1).symbol) {
                return _board.TileAt(2, 0).symbol;
            }
        }

        return Symbol.EMPTY;
    }
}
