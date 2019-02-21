export class Arabic {
    constructor(public number: number) {}

    toRoman(): string {
        const translation = {
            'C': 100,
            'L': 50,
            'X': 10,
            'V': 5
        };

        let roman = '';
        let remainder = this.number;

        for (let t in translation) {
            if (remainder === translation[t] - 1) {
                roman += 'I';
                remainder += 1;
            }

            if (remainder >= translation[t]) {
                roman += t;
                remainder -= translation[t];
            }
        }

        for (let i = 0; i < remainder; i++) {
            roman += 'I';
        }
        return roman;
    }
}
