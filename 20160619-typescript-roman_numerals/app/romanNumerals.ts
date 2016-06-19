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

        const length = normalNumber.toString().length;
        const base = Math.pow(10, length - 1);

        return RomanNumerals.ROMAN_SYMBOLS[base] + this.convert(normalNumber - base);
    }

}