const EMPTY_SPACE = ' ';
const NEW_LINE = '\n';

const lastIndexOfSpace = s => s.lastIndexOf(EMPTY_SPACE);
const replaceLastSpaceByNewLine = s => s.substring(0, lastIndexOfSpace(s)) + NEW_LINE + s.substring(lastIndexOfSpace(s) + 1);

const length = s => s.length;

const not = x => !x;
const contains = searchValue => s => s.indexOf(searchValue) > -1;
const containsSpaces = contains(EMPTY_SPACE);

const splitAt = position => s => [s.substring(0, position), s.substring(position)];
const head = x => x[0];
const rest = x => x[1];

export default class Wrapper {

    wrap(text: string, columns: number): string {
        const wrap = t => this.wrap(t, columns);
        const splitAtColumn = splitAt(columns);

        if (length(text) < columns) {
            return text;
        }

        if (EMPTY_SPACE === head(rest(splitAtColumn(text)))) {
            return head(splitAtColumn(text)) + NEW_LINE + wrap(rest(splitAt(columns + 1)(text)));
        }

        if (not(containsSpaces(text))) {
            return head(splitAtColumn(text)) + NEW_LINE + wrap(rest(splitAtColumn(text)));
        }

        return replaceLastSpaceByNewLine(head(splitAtColumn(text))) + wrap(rest(splitAtColumn(text)));
    }

}
