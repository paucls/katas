package parrot;

public abstract class Parrot {

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

    protected double getBaseSpeed() {
        return 12.0;
    }

}
