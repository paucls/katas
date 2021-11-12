package com.katas;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Position> cells = new ArrayList();

    public boolean isEmpty() {
        return cells.isEmpty();
    }

    public void setAliveAt(int x, int y) {
        cells.add(new Position(x, y));
    }

    public boolean isAliveAt(int x, int y) {
        return cells.stream().anyMatch(position -> position.equals(new Position(x, y)));
    }
}
