public class Game {
    private Symbol _lastSymbol = Symbol.EMPTY;
    private Board _board = new Board();

    public void play(Symbol symbol, int x, int y) throws Exception {
        if (isFirstMove()) {
            validateFirstPlayer(symbol);
        } else {
            validateNextPlayer(symbol);
        }

        Position position = new Position(x, y);
        validatePosition(position);

        updateGameState(symbol, position);
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

    private void validatePosition(Position position) throws Exception {
        if (_board.tileAt(position.x(), position.y()).isTaken()) {
            throw new Exception("Invalid position");
        }
    }

    private void updateGameState(Symbol symbol, Position position) {
        _lastSymbol = symbol;
        _board.addTileAt(symbol, position);
    }

    public Symbol winner() {
        if (_board.isRowTaken(0) && _board.isRowFullWithSameSymbol(0)) {
            return _board.tileAt(0, 0).symbol;
        }

        if (_board.isRowTaken(1) && _board.isRowFullWithSameSymbol(1)) {
            return _board.tileAt(1, 0).symbol;
        }

        if (_board.isRowTaken(2) && _board.isRowFullWithSameSymbol(2)) {
            return _board.tileAt(2, 0).symbol;
        }

        return Symbol.EMPTY;
    }
}
