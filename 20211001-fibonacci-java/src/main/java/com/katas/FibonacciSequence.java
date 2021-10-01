package com.katas;

public class FibonacciSequence {
    public int numberAt(int position) {
        if (position <= 2)
            return position - 1;
        return numberAt(position - 1) + numberAt(position - 2);
    }
}
