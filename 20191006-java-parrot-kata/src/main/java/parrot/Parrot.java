package parrot;

public class Parrot {

    private ParrotTypeEnum type;
    protected int numberOfCoconuts;
    private double voltage;
    private boolean isNailed;

    protected Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public static Parrot createParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        if (type == ParrotTypeEnum.EUROPEAN) {
            return new EuropeanParrot(type, numberOfCoconuts, voltage, isNailed);
        } else if (type == ParrotTypeEnum.AFRICAN) {
            return new AfricanParrot(type, numberOfCoconuts, voltage, isNailed);
        } else if (type == ParrotTypeEnum.NORWEGIAN_BLUE) {
            return new NorwegianBlueParrot(type, numberOfCoconuts, voltage, isNailed);
        }
        throw new RuntimeException("Should be unreachable");
    }

    public double getSpeed() {
        switch (type) {
            case NORWEGIAN_BLUE:
                return (isNailed) ? 0 : getBaseSpeed(voltage);
            default:
                throw new RuntimeException("Should be unreachable");
        }
    }

    private double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    protected double getLoadFactor() {
        return 9.0;
    }

    protected double getBaseSpeed() {
        return 12.0;
    }

}
