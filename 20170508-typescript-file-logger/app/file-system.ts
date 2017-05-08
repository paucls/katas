import * as fs from 'fs';

export default class FileSystem {

    write(path: string, text: string) {
        fs.writeFileSync('log.txt', text);
    }

}