import { NumberTheory } from './number-theory';

export class Fraction {
    constructor(private numerator: number,
                private denominator: number = 1) {
        const gcd = NumberTheory.gcd(numerator, denominator);
        if (gcd > 1) {
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }
    }

    plus(that: Fraction): Fraction {
        return new Fraction(
            this.numerator * that.denominator + that.numerator * this.denominator,
            this.denominator * that.denominator);
    }

    equals(that: Fraction): boolean {
        return this.numerator === that.numerator &&
            this.denominator === that.denominator;
    }
}
