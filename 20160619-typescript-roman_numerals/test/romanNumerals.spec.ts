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

        it('should convert 30 to XXX', () => {
            expect(RomanNumerals.convert(30)).to.be.equal("XXX");
        });

        it('should convert 2321 to MMCCCXXI', () => {
            expect(RomanNumerals.convert(2321)).to.be.equal("MMCCCXXI");
        });

    });

});