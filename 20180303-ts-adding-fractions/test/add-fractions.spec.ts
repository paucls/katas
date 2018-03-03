import { expect } from 'chai';
import { Fraction } from '../app/fraction';

describe('Add Fractions', () => {

    beforeEach(() => {
    });

    it('zero plus zero', () => {
        const sum = new Fraction(0).plus(new Fraction(0));

        expect(sum.intValue()).to.equal(0);
    });

});
