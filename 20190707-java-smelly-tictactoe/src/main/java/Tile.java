public class Tile {
    public static final char EMPTY_TILE_SYMBOL = ' ';

    public int X;
    public int Y;
    public char Symbol;

    public Tile(int x, int y) {
        this.X = x;
        this.Y = y;
        this.Symbol = EMPTY_TILE_SYMBOL;
    }

    public boolean isTaken() {
        return Symbol != EMPTY_TILE_SYMBOL;
    }
}