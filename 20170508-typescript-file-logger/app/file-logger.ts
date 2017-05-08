import FileSystem from "./file-system";
export default class FileLogger {

    constructor(private fileSystem: FileSystem) {}

    log(text: string) {
        this.fileSystem.write('log.txt', text);
    }

}