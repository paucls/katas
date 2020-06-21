public class Rock implements Shape {
    @Override
    public boolean beats(Shape scissor) {
        return true;
    }
}
