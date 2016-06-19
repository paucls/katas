export class RomanNumerals {

    static ROMAN_SYMBOLS = {
        0: '',
        1: 'I',
        10: 'X'
    };

    static convert(normalNumber:number) {
        return RomanNumerals.ROMAN_SYMBOLS[normalNumber];
    }

}