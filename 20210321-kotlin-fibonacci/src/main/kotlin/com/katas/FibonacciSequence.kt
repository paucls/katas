package com.katas

class FibonacciSequence {
    fun numberAt(position: Int): Int {
        if (position < 2)
            return position
        return numberAt(position - 1) + numberAt(position - 2)
    }
}
