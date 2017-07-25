const EMPTY_SPACE = ' ';
const NEW_LINE = '\n';

const replace = searchValue => replaceValue => s => s.replace(searchValue, replaceValue);
const replaceSpacesByNewLines = replace(EMPTY_SPACE)(NEW_LINE);

export default class Wrapper {

    wrap(text: string, columns: number): string {
        if (text.length < columns) {
            return text;
        }
        return replaceSpacesByNewLines(text);
    }

}
