import { cases } from 'jasmine-parameterized';
import { Arabic } from '../src/roman_numerals';

describe('Roman Numerals', () => {

    cases([
        [1, 'I'],
        [2, 'II'],
        [3, 'III'],
        [4, 'IV'],
        [5, 'V'],
        [6, 'VI'],
        [9, 'IX'],
        [10, 'X'],
        [12, 'XII'],
        [16, 'XVI'],
        [20, 'XX'],
        [50, 'L']
        // [38, 'XXXVIII']
    ]).it('can be parsed from arabic', ([arabic, roman]) => {
        expect(toRoman(arabic)).toEqual(roman);
    });

    function toRoman(number: number) {
        return new Arabic(number).toRoman();
    }
});
