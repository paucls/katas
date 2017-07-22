const NEW_LINE = '\n';
const EMPTY_SPACE = ' ';

export default class Wrapper {

    wrap(text: string, columns: number): string {
        if (text.length < columns) {
            return text;
        }

        const chunk1 = text.substring(0, columns);
        const chunk2 = text.substring(columns);

        if (chunk1.indexOf(EMPTY_SPACE) < 0) {
            return chunk1 + NEW_LINE + this.wrap(chunk2, columns);
        }

        if (chunk2[0] === EMPTY_SPACE) {
            return chunk1 + NEW_LINE + this.wrap(chunk2.substring(1), columns);
        }

        return chunk1.replace(EMPTY_SPACE, NEW_LINE) + this.wrap(chunk2, columns);
    }

}
