import java.time.LocalDate

data class Transaction(
        val date: LocalDate,
        val amount: Long,
        val balance: Long
)

