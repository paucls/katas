package parrot;

public class AfricanParrot extends Parrot {
    public static final int MIN_SPEED = 0;
    private static final double LOAD_FACTOR = 9.0;
    private double numberOfCoconuts;

    public AfricanParrot(int numberOfCoconuts) {
        this.numberOfCoconuts = numberOfCoconuts;
    }

    @Override
    public double getSpeed() {
        return Math.max(MIN_SPEED, BASE_SPEED - LOAD_FACTOR * numberOfCoconuts);
    }
}
