import { expect } from 'chai';

describe('Greatest Common Divisor', () => {

    it('1 and 1', () => {
        expect(gcd(1, 1)).to.be.equal(1);
    });

    it('42 and 56', () => {
        expect(gcd(42, 56)).to.be.equal(14);
    });

});

function gcd(a: number, b: number): number {
    while (b !== 0) {
        const t = b;
        b = a % b;
        a = t;
    }
    return a;
}