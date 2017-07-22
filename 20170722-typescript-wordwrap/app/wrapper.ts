export default class Wrapper {

    wrap(text: string, columns: number): string {
        if (text.length < columns) {
            return text;
        }
        return text.replace(' ', '\n');
    }

}
