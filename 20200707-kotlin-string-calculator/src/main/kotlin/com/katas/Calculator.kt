package com.katas

class Calculator {
    fun add(s: String): Number {
        if (s.isEmpty())
            return 0
        return s.toInt()
    }
}
