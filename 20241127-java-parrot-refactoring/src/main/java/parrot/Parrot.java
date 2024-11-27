package parrot;

import java.util.Objects;

public class Parrot {

    private final ParrotTypeEnum type;
    protected final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    protected Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public static Parrot createParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        return switch (type) {
            case EUROPEAN -> new EuropeanParrot(type, numberOfCoconuts, voltage, isNailed);
            case AFRICAN -> new AfricanParrot(type, numberOfCoconuts, voltage, isNailed);
            case NORWEGIAN_BLUE -> new NorwegianBlueParrot(type, numberOfCoconuts, voltage, isNailed);
        };
    }

    public double getSpeed() {
        if (Objects.requireNonNull(type) == ParrotTypeEnum.NORWEGIAN_BLUE) {
            return (isNailed) ? 0 : getBaseSpeed(voltage);
        }
        return getBaseSpeed();
    }

    private double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    protected double getBaseSpeed() {
        return 12.0;
    }

    public String getCry() {
        return switch (type) {
            case EUROPEAN -> "Sqoork!";
            case AFRICAN -> "Sqaark!";
            case NORWEGIAN_BLUE -> voltage > 0 ? "Bzzzzzz" : "...";
        };
    }
}
