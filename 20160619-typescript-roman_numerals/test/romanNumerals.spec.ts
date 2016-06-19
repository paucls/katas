/// <reference path="../typings/globals/chai/index.d.ts" />
/// <reference path="../typings/globals/mocha/index.d.ts" />
import {expect} from 'chai';
import {RomanNumerals} from '../app/romanNumerals';

describe('RomanNumerals', () => {

    describe('convert()', () => {

        it('should return empty string for 0', () => {
            expect(RomanNumerals.convert(0)).to.be.equal("");
        });

    });

});