const NEW_LINE = '\n';
const EMPTY_SPACE = ' ';

export default class Wrapper {

    wrap(text: string, columns: number): string {
        if (text.length < columns) {
            return text;
        }

        const chunk = text.substring(0, columns);
        const rest = text.substring(columns);

        if (rest[0] === EMPTY_SPACE) {
            return chunk + NEW_LINE + this.wrap(rest.substring(1), columns);
        }

        if (chunk.indexOf(EMPTY_SPACE) < 0) {
            return chunk + NEW_LINE + this.wrap(rest, columns);
        }

        const lastSpaceIdx = chunk.lastIndexOf(EMPTY_SPACE);

        return chunk.substring(0, lastSpaceIdx) + NEW_LINE + this.wrap(chunk.substring(lastSpaceIdx + 1) + rest, columns);
    }

}
