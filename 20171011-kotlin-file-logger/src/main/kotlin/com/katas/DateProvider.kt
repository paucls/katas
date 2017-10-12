package com.katas

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DateProvider {
    fun currentDate(pattern: String = "yyyy-MM-dd"): String {
        val now = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern(pattern)
        return now.format(formatter)
    }
}