import FileLogger from './file-logger';
import FileSystem from "./file-system";

let fileSystem = new FileSystem();
let fileLogger = new FileLogger(fileSystem);

fileLogger.log('New message');