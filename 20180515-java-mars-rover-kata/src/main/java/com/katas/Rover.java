package com.katas;

class Rover {

    private String direction = "N";

    String reportPosition() {
        return "0:0:" + direction;
    }

    void execute(String commands) {
        if (commands.charAt(0) == 'R') {
            if (this.direction.equals("N")) this.direction = "E";
            else if (this.direction.equals("E")) this.direction = "S";
            else if (this.direction.equals("S")) this.direction = "W";
            else this.direction = "N";
        } else {
            if (this.direction.equals("N")) this.direction = "W";
            else if (this.direction.equals("W")) this.direction = "S";
            else if (this.direction.equals("S")) this.direction = "E";
            else this.direction = "N";
        }

    }
}
