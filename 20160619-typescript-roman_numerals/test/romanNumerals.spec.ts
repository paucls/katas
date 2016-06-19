/// <reference path="../typings/globals/chai/index.d.ts" />
/// <reference path="../typings/globals/mocha/index.d.ts" />
import {expect} from 'chai';
import {RomanNumerals} from '../app/romanNumerals';

describe('RomanNumerals', () => {

    describe('convert()', () => {

        it('should convert 0 to empty string', () => {
            expect(RomanNumerals.convert(0)).to.be.equal("");
        });

        it('should convert 1 to I', () => {
            expect(RomanNumerals.convert(1)).to.be.equal("I");
        });

        it('should convert 10 to X', () => {
            expect(RomanNumerals.convert(10)).to.be.equal("X");
        });

        it('should convert 100 to C', () => {
            expect(RomanNumerals.convert(100)).to.be.equal("C");
        });

        it('should convert 1000 to M', () => {
            expect(RomanNumerals.convert(1000)).to.be.equal("M");
        });

        it('should convert 2 to II', () => {
            expect(RomanNumerals.convert(2)).to.be.equal("II");
        });

        it('should convert 3 to III', () => {
            expect(RomanNumerals.convert(3)).to.be.equal("III");
        });

    });

});