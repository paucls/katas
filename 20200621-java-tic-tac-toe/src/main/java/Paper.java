public class Paper implements Shape {
    @Override
    public boolean beats(Shape shape) {
        return shape instanceof Rock;
    }
}
