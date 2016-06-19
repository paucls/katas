export class RomanNumerals {

    static ROMAN_SYMBOLS = {
        0: '',
        1: 'I',
        10: 'X',
        100: 'C',
        1000: 'M'
    };

    static convert(normalNumber:number): string {
        return RomanNumerals.ROMAN_SYMBOLS[normalNumber];
    }

}