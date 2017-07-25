const EMPTY_SPACE = ' ';
const NEW_LINE = '\n';

const replace = searchValue => replaceValue => s => s.replace(searchValue, replaceValue);
const replaceSpacesByNewLines = replace(EMPTY_SPACE)(NEW_LINE);

const length = s => s.length;

const not = x => !x;
const contains = searchValue => s => s.indexOf(searchValue) > -1;
const containsSpaces = contains(EMPTY_SPACE);

export default class Wrapper {

    wrap(text: string, columns: number): string {
        if (length(text) < columns) {
            return text;
        }

        if (not(containsSpaces(text))) {
            return text.substring(0, columns) + NEW_LINE + text.substring(columns);
        }

        return replaceSpacesByNewLines(text);
    }

}
