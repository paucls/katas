import FileSystem from "./file-system";

const LOG_FILE_PATH = 'log.txt';

export default class FileLogger {

    constructor(private fileSystem: FileSystem) {}

    log(text: string) {
        if (this.fileSystem.exists(LOG_FILE_PATH)) {
            this.fileSystem.append(LOG_FILE_PATH, text);
        }
        this.fileSystem.write(LOG_FILE_PATH, text);
    }

}