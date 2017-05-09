import FileSystem from "./file-system";

export default class FileLogger {

    constructor(private fileSystem: FileSystem) {
    }

    log(text: string) {
        const fileName = this.buildFileName();

        if (this.fileSystem.exists(fileName)) {
            this.fileSystem.append(fileName, text);
            return;
        }

        this.fileSystem.write(fileName, text);
    }

    private buildFileName() {
        const date = new Date();
        const year = date.getFullYear();
        let month = '' + (date.getMonth() + 1);
        let day = '' + date.getDate();

        if (month.length < 2) { month = '0' + month; }
        if (day.length < 2) { day = '0' + day; }

        return `log${year}${month}${day}.txt`;
    }

}