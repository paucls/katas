package com.katas;

import java.util.Objects;

public class GridPosition {

    final int x;
    final int y;

    GridPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GridPosition withX(int x) {
        return new GridPosition(x, this.y);
    }

    public GridPosition withY(int i) {
        return new GridPosition(this.x, i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridPosition that = (GridPosition) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "GridPosition{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
