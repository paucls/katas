import { expect } from 'chai';
import { NumberTheory } from '../app/number-theory';

describe('Greatest Common Divisor', () => {

    it('a number with itself', () => {
        expect(NumberTheory.gcd(1, 1)).to.be.equal(1);
        expect(NumberTheory.gcd(2, 2)).to.be.equal(2);
        expect(NumberTheory.gcd(-1, -1)).to.be.equal(1);
    });

    it('relatively prime', () => {
        expect(NumberTheory.gcd(7, 20)).to.be.equal(1);
        expect(NumberTheory.gcd(12, 13)).to.be.equal(1);
        expect(NumberTheory.gcd(-2, -3)).to.be.equal(1);
    });

    it('a number multiple of the other', () => {
        expect(NumberTheory.gcd(2, 4)).to.be.equal(2);
        expect(NumberTheory.gcd(3, 9)).to.be.equal(3);
    });

    it('common factor', () => {
        expect(NumberTheory.gcd(6, 8)).to.be.equal(2);
        expect(NumberTheory.gcd(12, 14)).to.be.equal(2);
        expect(NumberTheory.gcd(42, 56)).to.be.equal(14);
    });

    it('negatives', () => {
        expect(NumberTheory.gcd(-5, -7)).to.be.equal(1);
        expect(NumberTheory.gcd(-12, -14)).to.be.equal(2);
    });

});
