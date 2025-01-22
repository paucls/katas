package codingdojo.officecleaner1;


// A class to keep track of the X and Y positions
public record Coordinate(int x, int y) {
    @Override
    public String toString() {
        return x + "," + y;
    }
}
