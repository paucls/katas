package com.katas;

class Batch {
    private String title;
    private int count;

    Batch() {

    }

    Batch(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public String title() {
        return title;
    }

    public int count() {
        return count;
    }

    public void add(String title, int count) {
        this.title = title;
        this.count = count;
    }
}
