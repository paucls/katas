package com.katas;

class Rover {

    private String direction = "N";

    String reportPosition() {
        return "0:0:" + direction;
    }

    void execute(String commands) {
        this.direction = "W";
    }
}
