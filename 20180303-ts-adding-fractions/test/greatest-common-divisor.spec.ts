import { expect } from 'chai';

describe('Greatest Common Divisor', () => {

    it('a number with itself', () => {
        expect(gcd(1, 1)).to.be.equal(1);
        expect(gcd(2, 2)).to.be.equal(2);
        expect(gcd(-1, -1)).to.be.equal(1);
    });

    it('relatively prime', () => {
        expect(gcd(7, 20)).to.be.equal(1);
        expect(gcd(12, 13)).to.be.equal(1);
        expect(gcd(-2, -3)).to.be.equal(1);
    });

    it('a number multiple of the other', () => {
        expect(gcd(2, 4)).to.be.equal(2);
        expect(gcd(3, 9)).to.be.equal(3);
    });

    it('common factor', () => {
        expect(gcd(6, 8)).to.be.equal(2);
        expect(gcd(12, 14)).to.be.equal(2);
        expect(gcd(42, 56)).to.be.equal(14);
    });

    it('negatives', () => {
        expect(gcd(-5, -7)).to.be.equal(1);
        expect(gcd(-12, -14)).to.be.equal(2);
    });

});

function gcd(a: number, b: number): number {
    while (b !== 0) {
        const t = b;
        b = a % b;
        a = t;
    }
    return Math.abs(a);
}