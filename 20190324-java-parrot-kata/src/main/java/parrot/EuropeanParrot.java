package parrot;

public class EuropeanParrot extends Parrot {
    public EuropeanParrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        super();
    }

    @Override
    public double getSpeed() {
        return getBaseSpeed();
    }
}
