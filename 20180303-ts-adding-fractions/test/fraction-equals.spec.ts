import { expect } from 'chai';
import { Fraction } from '../app/fraction';

describe('Fraction Equals', () => {

    it('should be equal for same denominator and numerator', () => {
        expect(new Fraction(1, 3).equals(new Fraction(1, 3))).to.be.true;
    });

});