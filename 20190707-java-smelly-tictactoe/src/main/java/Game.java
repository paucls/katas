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

    private void updateGameState(Symbol symbol, Position position) throws Exception {
        _board.addTileAt(symbol, position);
        _lastSymbol = symbol;
    }

    public Symbol winner() {
        if (_board.isRowTakenWithSameSymbol(0)) {
            return _board.tileAt(0, 0).symbol;
        }

        if (_board.isRowTakenWithSameSymbol(1)) {
            return _board.tileAt(1, 0).symbol;
        }

        if (_board.isRowTakenWithSameSymbol(2)) {
            return _board.tileAt(2, 0).symbol;
        }

        return Symbol.EMPTY;
    }

}
