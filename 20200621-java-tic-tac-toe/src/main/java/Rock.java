public class Rock implements Shape {
    @Override
    public boolean beats(Shape shape) {
        return shape instanceof Scissors;
    }
}
