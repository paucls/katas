package com.katas;

public class Storage {

    private final Directory root = new Directory("/");

    public Directory rootDirectory() {
        return root;
    }

    public int totalSize() {
        return root.getSize();
    }
}
