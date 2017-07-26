import * as R from 'ramda';

const SPACE = ' ';
const NEW_LINE = '\n';

const containsSpaces = R.contains(SPACE);
const replaceLastSpace = s => R.reverse(R.replace(SPACE, NEW_LINE, R.reverse(s)));

export default class Wrapper {

    wrap(text: string, columns: number): string {
        const wrap = s => this.wrap(s, columns);
        const splitAtColumns = R.splitAt(columns);

        if (R.length(text) <= columns) {
            return text;
        }

        if (R.not(containsSpaces(text))) {
            return R.head(splitAtColumns(text)) + NEW_LINE + wrap(R.last(splitAtColumns(text)));
        }

        if (SPACE === text[columns]) {
            return R.head(splitAtColumns(text)) + NEW_LINE + wrap(R.trim(splitAtColumns(text)[1]));
        }

        return replaceLastSpace(R.head(splitAtColumns(text))) + wrap(R.last(splitAtColumns(text)));
    }

}
