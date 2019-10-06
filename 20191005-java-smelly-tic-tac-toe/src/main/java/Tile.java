public class Tile {
    public static final char EMPTY_SYMBOL = ' ';

    public int X;
    public int Y;
    public char Symbol;

    public Tile() {
    }

    public Tile(Position position) {
        this.X = position.x();
        this.Y = position.y();
        this.Symbol = EMPTY_SYMBOL;
    }
}