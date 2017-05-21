package com.katas;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class FileLogger {

    public static final String DATE_FORMAT = "yyyyMMdd";
    FileSystemAdapter fileSystem;

    public FileLogger(FileSystemAdapter fileSystemAdapter) {
        this.fileSystem = fileSystemAdapter;
    }

    public void log(String message) throws IOException {
        String fileName = buildFileName();

        if (fileSystem.exists(fileName)) {
            fileSystem.append(fileName, message);
            return;
        }

        fileSystem.write(fileName, message);
    }

    private String buildFileName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime now = LocalDateTime.now();
        String logDate = now.format(formatter);

        return "log" + logDate + ".txt";
    }

}
