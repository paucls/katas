export class Fraction {
    constructor(private numerator: number,
                private denominator: number = 1) {
    }

    plus(that: Fraction): Fraction {
        return new Fraction(this.numerator + that.numerator, this.denominator);
    }

    equals(that: Fraction): boolean {
        return this.numerator === that.numerator &&
            this.denominator === that.denominator;
    }
}
