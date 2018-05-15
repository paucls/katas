package com.katas;

class Rover {

    private String direction = "N";

    String reportPosition() {
        return "0:0:" + direction;
    }

    void execute(String commands) {
        if (this.direction.equals("N")) this.direction = "W";
        else if (this.direction.equals("W")) this.direction = "S";
        else if (this.direction.equals("S")) this.direction = "E";
        else this.direction = "N";
    }
}
