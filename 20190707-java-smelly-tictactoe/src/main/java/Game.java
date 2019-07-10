public class Game {
    private Symbol _lastSymbol = Symbol.EMPTY;
    private Board _board = new Board();

    public void Play(Symbol symbol, int x, int y) throws Exception {
        if (isFirstMove()) {
            validateFirstPlayer(symbol);
        } else {
            validateNextPlayer(symbol);
        }

        validatePosition(x, y);

        // update game state
        _lastSymbol = symbol;
        _board.addTileAt(symbol, x, y);
    }

    private boolean isFirstMove() {
        return _lastSymbol == Symbol.EMPTY;
    }

    private void validateFirstPlayer(Symbol symbol) throws Exception {
        if (symbol == Symbol.O) {
            throw new Exception("Invalid first player");
        }
    }

    private void validateNextPlayer(Symbol symbol) throws Exception {
        if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
    }

    private void validatePosition(int x, int y) throws Exception {
        if (_board.tileAt(x, y).isTaken()) {
            throw new Exception("Invalid position");
        }
    }

    public Symbol Winner() {
        //if the positions in first row are taken
        if (_board.tileAt(0, 0).isTaken() &&
                _board.tileAt(0, 1).isTaken() &&
                _board.tileAt(0, 2).isTaken()) {
            //if first row is full with same symbol
            if (_board.tileAt(0, 0).symbol == _board.tileAt(0, 1).symbol &&
                    _board.tileAt(0, 2).symbol == _board.tileAt(0, 1).symbol) {
                return _board.tileAt(0, 0).symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.tileAt(1, 0).isTaken() &&
                _board.tileAt(1, 1).isTaken() &&
                _board.tileAt(1, 2).isTaken()) {
            //if middle row is full with same symbol
            if (_board.tileAt(1, 0).symbol == _board.tileAt(1, 1).symbol &&
                    _board.tileAt(1, 2).symbol == _board.tileAt(1, 1).symbol) {
                return _board.tileAt(1, 0).symbol;
            }
        }

        //if the positions in first row are taken
        if (_board.tileAt(2, 0).isTaken() &&
                _board.tileAt(2, 1).isTaken() &&
                _board.tileAt(2, 2).isTaken()) {
            //if middle row is full with same symbol
            if (_board.tileAt(2, 0).symbol == _board.tileAt(2, 1).symbol &&
                    _board.tileAt(2, 2).symbol == _board.tileAt(2, 1).symbol) {
                return _board.tileAt(2, 0).symbol;
            }
        }

        return Symbol.EMPTY;
    }
}
