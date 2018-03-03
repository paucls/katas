import { expect } from 'chai';
import { Fraction } from '../app/fraction';

describe('Add Fractions', () => {

    it('zero plus zero', () => {
        const sum = new Fraction(0).plus(new Fraction(0));

        expect(sum.intValue()).to.equal(0);
    });

    it('non zero plus zero', () => {
        const sum = new Fraction(1).plus(new Fraction(0));

        expect(sum.intValue()).to.equal(1);
    });

    it('zero plus non zero', () => {
        const sum = new Fraction(0).plus(new Fraction(4));

        expect(sum.intValue()).to.equal(4);
    });

});
