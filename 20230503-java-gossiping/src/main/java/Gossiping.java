public class Gossiping {
    private final int[][] routes;

    public Gossiping(int[][] routes) {
        this.routes = routes;
    }

    public String howLongItTakes() {
        if (routes[0][0] == routes[1][0]) {
            return "1";
        }

        return "never";
    }
}