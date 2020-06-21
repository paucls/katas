public class Scissors implements Shape {
    @Override
    public boolean beats(Shape scissor) {
        return scissor instanceof Paper;
    }
}
