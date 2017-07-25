const EMPTY_SPACE = ' ';
const NEW_LINE = '\n';

export default class Wrapper {

    wrap(text: string, columns: number): string {
        if (text.length < columns) {
            return text;
        }
        return text.replace(EMPTY_SPACE, NEW_LINE);
    }

}
