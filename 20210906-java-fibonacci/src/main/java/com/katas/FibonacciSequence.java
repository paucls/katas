package com.katas;

public class FibonacciSequence {
    public int numberAt(int index) {
        if (index < 2)
            return index;
        return numberAt(index - 1) + numberAt(index - 2);
    }
}
