package com.katas;

import com.sun.javafx.binding.StringFormatter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {

    private static final String FILE_NAME_TEMPLATE = "log%s.txt";
    private static final String DATE_FORMAT = "yyyyMMdd";

    private FileSystemAdapter fileSystem;
    private DateProvider dateProvider;

    public FileLogger(FileSystemAdapter fileSystemAdapter, DateProvider dateProvider) {
        this.fileSystem = fileSystemAdapter;
        this.dateProvider = dateProvider;
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
        String date = dateProvider.now().format(formatter);

        return String.format(FILE_NAME_TEMPLATE, date);
    }

}
