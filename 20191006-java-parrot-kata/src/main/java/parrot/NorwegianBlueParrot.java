package parrot;

public class NorwegianBlueParrot extends Parrot {
    protected NorwegianBlueParrot(int numberOfCoconuts, double voltage, boolean isNailed) {
        super(numberOfCoconuts, voltage, isNailed);
    }

    @Override
    public double getSpeed() {
        return (isNailed) ? 0 : baseSpeed();
    }

    private double baseSpeed() {
        return Math.min(24.0, voltage * getBaseSpeed());
    }
}
