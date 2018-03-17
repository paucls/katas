import { expect } from 'chai';
import { Fraction } from '../app/fraction';

describe('Add Fractions', () => {

    it('zero plus zero', () => {
        expect(new Fraction(0).plus(new Fraction(0)).equals(new Fraction(0))).to.be.true;
    });

    it('non zero plus zero', () => {
        expect(new Fraction(1).plus(new Fraction(0)).equals(new Fraction(1))).to.be.true;
    });

    it('zero plus non zero', () => {
        expect(new Fraction(0).plus(new Fraction(4)).equals(new Fraction(4))).to.be.true;
    });

    it('non negative non zero operands', () => {
        expect(new Fraction(2).plus(new Fraction(3)).equals(new Fraction(5))).to.be.true;
    });

    it('negative plus non zero', () => {
        expect(new Fraction(-3).plus(new Fraction(2)).equals(new Fraction(-1))).to.be.true;
    });

    it('two fractions with same denominator', () => {
        expect(new Fraction(1, 5).plus(new Fraction(2, 5)).equals(new Fraction(3, 5))).to.be.true;
    });

    it('two fractions with different denominators without simplifying', () => {
        expect(new Fraction(1, 3).plus(new Fraction(1, 5)).equals(new Fraction(8, 15))).to.be.true;
    });
});
