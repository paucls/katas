import { expect } from 'chai';
import { Fraction } from '../app/fraction';

describe('Fraction Equals', () => {

    it('should be equal for same denominator and numerator', () => {
        expect(new Fraction(1, 3).equals(new Fraction(1, 3))).to.be.true;
    });

    it('should not be equal for different denominator or numerator', () => {
        expect(new Fraction(2, 3).equals(new Fraction(1, 3))).to.be.false;
        expect(new Fraction(3, 3).equals(new Fraction(3, 2))).to.be.false;
    });

});