import { expect } from 'chai';
import { Fraction } from '../app/fraction';

describe('Add Fractions', () => {

    it('zero plus zero', () => {
        expect(new Fraction(0).plus(new Fraction(0)).intValue()).to.equal(0);
    });

    it('non zero plus zero', () => {
        expect(new Fraction(1).plus(new Fraction(0)).intValue()).to.equal(1);
    });

    it('zero plus non zero', () => {
        expect(new Fraction(0).plus(new Fraction(4)).intValue()).to.equal(4);
    });

    it('non negative non zero operands', () => {
        expect(new Fraction(2).plus(new Fraction(3)).intValue()).to.equal(5);
    });

    it('negative plus non zero', () => {
        expect(new Fraction(-3).plus(new Fraction(2)).intValue()).to.equal(-1);
    });
});
