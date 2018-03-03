export class Fraction {
    constructor(private integerValue: number) {
    }

    plus(that: Fraction): Fraction {
        if (this.integerValue === 0)
            return that;
        else
            return new Fraction(this.integerValue + that.integerValue);
    }

    intValue(): number {
        return this.integerValue;
    }
}
