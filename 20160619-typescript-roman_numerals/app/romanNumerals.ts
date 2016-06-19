export class RomanNumerals {

    static ROMAN_SYMBOLS = {
        1: 'I',
        10: 'X',
        100: 'C',
        1000: 'M'
    };

    static convert(normalNumber:number):string {
        if (normalNumber === 0) {
            return '';
        }

        if (normalNumber < 10) {
            return RomanNumerals.ROMAN_SYMBOLS[1] + this.convert(normalNumber - 1);
        }

        if (normalNumber < 100) {
            return RomanNumerals.ROMAN_SYMBOLS[10] + this.convert(normalNumber - 10);
        }

        return RomanNumerals.ROMAN_SYMBOLS[normalNumber];
    }

}