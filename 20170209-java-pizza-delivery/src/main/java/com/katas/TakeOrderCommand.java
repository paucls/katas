package com.katas;

public class TakeOrderCommand {
    String name;

    public TakeOrderCommand(String name, String phone, String address, String pizza, int quantity) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
