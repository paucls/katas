package com.katas;

import java.io.IOException;

public class FileLogger {

    public static final String LOG_FILE_PATH = "log.txt";

    FileSystemAdapter fileSystem;

    public FileLogger(FileSystemAdapter fileSystemAdapter) {
        this.fileSystem = fileSystemAdapter;
    }

    public void log(String message) throws IOException {
        if (fileSystem.exists(LOG_FILE_PATH)) {
            fileSystem.append(LOG_FILE_PATH, message);
            return;
        }

        fileSystem.write(LOG_FILE_PATH, message);
    }

}
