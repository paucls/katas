public class Tile {

    final public int x;
    final public int y;
    public Symbol symbol;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.symbol = Symbol.EMPTY;
    }

    public boolean isTaken() {
        return symbol != Symbol.EMPTY;
    }
}