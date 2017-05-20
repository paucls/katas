package com.katas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSystemAdapter {

    public void write(String path, String content) throws IOException {
        Files.write(Paths.get(path), content.getBytes());
    }

    public void append(String path, String content) {
    }

    public boolean exists(String path) {
        return false;
    }
}
