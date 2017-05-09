import * as fs from 'fs';

export default class FileSystem {

    exists(path: string) {
        return fs.exists(path);
    }

    append(path: string, text: string) {
        fs.appendFileSync(path, text);
    }

    write(path: string, text: string) {
        fs.writeFileSync(path, text);
    }

}