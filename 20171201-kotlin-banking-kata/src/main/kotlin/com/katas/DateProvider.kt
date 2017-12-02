package com.katas

import java.time.LocalDate

class DateProvider {
    fun currentDate(): LocalDate {
        return LocalDate.now()
    }
}
