package com.katas;

public class Resource {
    protected final String name;
    protected final int size;

    public Resource(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String name() {
        return name;
    }

    public int getSize() {
        return size;
    }
}
