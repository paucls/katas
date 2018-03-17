export class Fraction {
    constructor(private numerator: number,
                private denominator: number = 1) {
    }

    plus(that: Fraction): Fraction {
        if (this.denominator !== that.denominator) {
            return new Fraction(
                this.numerator * that.denominator + that.numerator * this.denominator,
                this.denominator * that.denominator);
        }
        return new Fraction(this.numerator + that.numerator, this.denominator);
    }

    equals(that: Fraction): boolean {
        return this.numerator === that.numerator &&
            this.denominator === that.denominator;
    }
}
