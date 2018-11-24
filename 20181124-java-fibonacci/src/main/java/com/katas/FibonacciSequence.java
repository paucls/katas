package com.katas;

class FibonacciSequence {
    int getNumber(int index) {
        if (index < 2)
            return index;
        return index - 1;
    }
}
