export class Fraction {
    constructor(private integerValue: number) {
    }

    plus(that: Fraction): Fraction {
        return this;
    }

    intValue(): number {
        return this.integerValue;
    }
}
