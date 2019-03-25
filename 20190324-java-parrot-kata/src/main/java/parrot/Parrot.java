package parrot;

public abstract class Parrot {

    public static final double BASE_SPEED = 12.0;

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
        return BASE_SPEED;
    }

}
