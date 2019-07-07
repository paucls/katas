public class Tile {
    public static final Symbol EMPTY_TILE_SYMBOL = Symbol.EMPTY;
    public static final Symbol O_SYMBOL = Symbol.O;
    public static final Symbol X_SYMBOL = Symbol.X;

    final public int x;
    final public int y;
    public Symbol symbol;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.symbol = EMPTY_TILE_SYMBOL;
    }

    public boolean isTaken() {
        return symbol != EMPTY_TILE_SYMBOL;
    }
}