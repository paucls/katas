export class RomanNumerals {

    convert(normalNumber:number):string {
        if (normalNumber === 0) {
            return '';
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
    'X' = 10,
    'C' = 100,
    'M' = 1000
}