package parrot;

public abstract class Parrot {

    protected int numberOfCoconuts;
    protected double voltage;
    protected boolean isNailed;

    protected Parrot(int numberOfCoconuts, double voltage, boolean isNailed) {
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public static Parrot createParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        if (type == ParrotTypeEnum.EUROPEAN) {
            return new EuropeanParrot(numberOfCoconuts, voltage, isNailed);
        } else if (type == ParrotTypeEnum.AFRICAN) {
            return new AfricanParrot(numberOfCoconuts, voltage, isNailed);
        } else if (type == ParrotTypeEnum.NORWEGIAN_BLUE) {
            return new NorwegianBlueParrot(numberOfCoconuts, voltage, isNailed);
        }
        throw new RuntimeException("Should be unreachable");
    }

    public abstract double getSpeed();

    protected double getBaseSpeed() {
        return 12.0;
    }

}
