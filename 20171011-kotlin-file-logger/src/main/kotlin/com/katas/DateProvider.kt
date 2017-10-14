package com.katas

import java.time.LocalDateTime

object DateProvider {
    fun currentDate(): LocalDateTime {
        return LocalDateTime.now()
    }
}