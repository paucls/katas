const EMPTY_SPACE = ' ';
const NEW_LINE = '\n';

const replace = searchValue => replaceValue => s => s.replace(searchValue, replaceValue);
const replaceSpacesByNewLines = replace(EMPTY_SPACE)(NEW_LINE);

const length = s => s.length;

const not = x => !x;
const contains = searchValue => s => s.indexOf(searchValue) > -1;
const containsSpaces = contains(EMPTY_SPACE);

const chunk = chunkSize => s => s.substring(0, chunkSize);
const splitAt = position => s => [s.substring(0, position), s.substring(position)];

export default class Wrapper {

    wrap(text: string, columns: number): string {
        const splitAtColumn = splitAt(columns);

        if (length(text) < columns) {
            return text;
        }

        if (not(containsSpaces(text))) {
            return splitAtColumn(text)[0] + NEW_LINE + this.wrap(splitAtColumn(text)[1], columns);
        }

        return replaceSpacesByNewLines(text);
    }

}
