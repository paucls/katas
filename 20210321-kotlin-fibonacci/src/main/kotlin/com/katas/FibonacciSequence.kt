package com.katas

class FibonacciSequence {
    fun numberAt(position: Int): Int {
        if (position < 2)
            return position
        return 1
    }
}
