package parrot;

public class EuropeanParrot extends Parrot {
    protected EuropeanParrot(int numberOfCoconuts, double voltage, boolean isNailed) {
        super(numberOfCoconuts, voltage, isNailed);
    }

    @Override
    public double getSpeed() {
        return BASE_SPEED;
    }
}
