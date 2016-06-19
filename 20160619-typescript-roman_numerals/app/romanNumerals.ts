export class RomanNumerals {

    static convert(normalNumber:number):string {
        if (normalNumber === 0) {
            return '';
        }

        const length = normalNumber.toString().length;
        const base = Math.pow(10, length - 1);

        return RomanNumeralSymbols[base] + this.convert(normalNumber - base);
    }

}

enum RomanNumeralSymbols {
    'I' = 1,
    'X' = 10,
    'C' = 100,
    'M' = 1000
}