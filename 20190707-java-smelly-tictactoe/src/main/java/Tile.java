public class Tile {
    public static final char EMPTY_TILE_SYMBOL = ' ';

    public int x;
    public int y;
    public char symbol;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.symbol = EMPTY_TILE_SYMBOL;
    }

    public boolean isTaken() {
        return symbol != EMPTY_TILE_SYMBOL;
    }
}