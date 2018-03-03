export class Fraction {
    constructor(private integerValue: number) {
    }

    plus(that: Fraction): Fraction {
        if (this.integerValue === 0)
            return that;
        else
            return this;
    }

    intValue(): number {
        return this.integerValue;
    }
}
