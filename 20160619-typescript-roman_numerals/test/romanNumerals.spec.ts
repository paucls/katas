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

    });

});