package parrot;

public abstract class Parrot {

    private final ParrotTypeEnum type;
    protected final int numberOfCoconuts;
    protected final double voltage;
    protected final boolean isNailed;

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

    public abstract double getSpeed();

    protected double getBaseSpeed() {
        return 12.0;
    }

    public abstract String getCry();
}