package com.katas;

import java.nio.file.Files;

public class FileLogger {

    FileSystemAdapter fileSystem;

    public FileLogger(FileSystemAdapter fileSystemAdapter) {
        this.fileSystem = fileSystemAdapter;
    }

    public void log(String text) {
    }

}
