const NEW_LINE = '\n';
const EMPTY_SPACE = ' ';

export default class Wrapper {

    wrap(text: string, columns: number): string {
        if (text.length < columns) {
            return text;
        }

        if (text.indexOf(EMPTY_SPACE) < 0) {
            const chunks = this.chunk(text, columns);
            return chunks.join(NEW_LINE);
        }

        return text.replace(EMPTY_SPACE, NEW_LINE);
    }

    private chunk(text: string, size: number) {
        return text.match(new RegExp('.{1,' + size + '}', 'g'));
    }
}
