import * as R from 'ramda';

const SPACE = ' ';
const NEW_LINE = '\n';

const containsSpaces = R.contains(SPACE);

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

        return R.replace(SPACE, NEW_LINE, text);
    }

}
