package com.katas;

enum Direction {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private static final int left = -1;
    private static final int right = 1;

    private int index;

    Direction(int index) {
        this.index = index;
    }

    public Direction left() {
        int leftIndex = Math.floorMod(index + left, values().length);

        return values()[leftIndex];
    }

    public Direction right() {
        int rightIndex = Math.floorMod(index + right, values().length);

        return values()[rightIndex];
    }
}
