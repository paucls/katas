export class RomanNumerals {

    convert(normalNumber:number):string {
        if (normalNumber === 0) {
            return '';
        }

        if (normalNumber === 5 || normalNumber === 50 || normalNumber === 500) {
            return RomanNumeralSymbols[normalNumber];
        }

        const base = this.getNumberBase(normalNumber);

        return RomanNumeralSymbols[base] + this.convert(normalNumber - base);
    }

    private getNumberBase(number:number) {
        const length = number.toString().length;
        return Math.pow(10, length - 1);
    }

}

enum RomanNumeralSymbols {
    'I' = 1,
    'V' = 5,
    'X' = 10,
    'L' = 50,
    'C' = 100,
    'D' = 500,
    'M' = 1000
}