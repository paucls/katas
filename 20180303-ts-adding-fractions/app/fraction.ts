export class Fraction {
    constructor(private integerValue: number) {
    }

    plus(that: Fraction): Fraction {
        return new Fraction(this.integerValue + that.integerValue);
    }

    intValue(): number {
        return this.integerValue;
    }
}
