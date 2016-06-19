export class RomanNumerals {

    static NO_SYMBOL = '';
    static SYMBOL_FOR_1 = 'I';

    static convert(normalNumber:number) {
        if (normalNumber === 0) {
            return this.NO_SYMBOL;
        }

        return this.SYMBOL_FOR_1;
    }

}