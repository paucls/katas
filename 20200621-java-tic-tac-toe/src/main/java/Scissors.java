public class Scissors implements Shape {
    @Override
    public boolean beats(Shape shape) {
        return shape instanceof Paper;
    }
}
