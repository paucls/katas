package parrot;

public class NorwegianBlueParrot extends Parrot {
    public static final double MAX_SPEED = 24.0;
    public static final int NAILED_SPEED = 0;
    private final double voltage;
    private final boolean isNailed;

    public NorwegianBlueParrot(double voltage, boolean isNailed) {
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    @Override
    public double getSpeed() {
        return isNailed ? NAILED_SPEED : getBaseSpeed(voltage);
    }

    private double getBaseSpeed(double voltage) {
        return Math.min(MAX_SPEED, voltage * BASE_SPEED);
    }
}
