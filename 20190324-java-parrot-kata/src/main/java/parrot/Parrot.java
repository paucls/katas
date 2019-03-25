package parrot;

public abstract class Parrot {

    private ParrotTypeEnum type;
    private int numberOfCoconuts;
    private double voltage;
    private boolean isNailed;

    private Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public Parrot() {
    }

    public static Parrot createParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        if (type == ParrotTypeEnum.EUROPEAN)
            return new EuropeanParrot();
        if (type == ParrotTypeEnum.AFRICAN)
            return new AfricanParrot(numberOfCoconuts);
        if (type == ParrotTypeEnum.NORWEGIAN_BLUE)
            return new NorwegianBlueParrot(voltage, isNailed);

        throw new RuntimeException("Should be unreachable");
    }

    abstract public double getSpeed();

    protected double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    protected double getLoadFactor() {
        return 9.0;
    }

    protected double getBaseSpeed() {
        return 12.0;
    }

}
