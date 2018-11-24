package com.katas;

class FibonacciSequence {
    int getNumber(int index) {
        if (index < 2)
            return index;
        return getNumber(index - 1) + getNumber(index - 2);
    }
}
