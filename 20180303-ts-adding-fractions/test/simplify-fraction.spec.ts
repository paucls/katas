import { expect } from 'chai';
import { Fraction } from '../app/fraction';

describe('Simplify Fraction', () => {

    it('should not simplify a fraction that is already in lowest terms', () => {
        expect(new Fraction(1, 3)).to.deep.equal(new Fraction(1, 3));
    });

    it('should simplify fraction to lowest terms', () => {
        expect(new Fraction(2, 4)).to.deep.equal(new Fraction(1, 2));
    });

    it('should simplify fraction to whole number', () => {
        expect(new Fraction(6, 2)).to.deep.equal(new Fraction(3));
    });

});