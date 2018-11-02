package com.katas;

class Board {
    private Token token;

    String getCell(int x, int y) {
        return token.toString();
    }

    void place(Token token, int i, int i1) throws CannotPlaceInOccupiedPossition {
        if (this.token != null) throw new CannotPlaceInOccupiedPossition();
        this.token = token;
    }
}
