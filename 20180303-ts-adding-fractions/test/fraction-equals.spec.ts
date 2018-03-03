import { expect } from 'chai';
import { Fraction } from '../app/fraction';

describe('Fraction Equals', () => {

    it('should be equal for same denominator and numerator', () => {
        expect(new Fraction(1, 3).equals(new Fraction(1, 3))).to.be.true;
    });

    it('should not be equal for different numerator', () => {
        expect(new Fraction(2, 3).equals(new Fraction(1, 3))).to.be.false;
    });

    it('should not be equal for different denominator', () => {
        expect(new Fraction(1, 3).equals(new Fraction(1, 2))).to.be.false;
    });

    it('should be equal for same whole numbers', () => {
        expect(new Fraction(5).equals(new Fraction(5))).to.be.true;
    });

    it('should not be equal for different whole numbers', () => {
        expect(new Fraction(7).equals(new Fraction(2))).to.be.false;
    });

    it('whole number equals than same fraction', () => {
        expect(new Fraction(4).equals(new Fraction(4, 1))).to.be.true;
    });

});