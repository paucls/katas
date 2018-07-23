import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import java.time.LocalDate

object AccountServiceTest : Spek({

    describe("Account Service") {

        it("should register a deposit transaction") {
            val now = LocalDate.now()
            val console: Console = mock()
            val calendar: Calendar = mock()
            val transactions: Transactions = mock()
            val account = AccountService(console, calendar, transactions)

            whenever(calendar.currentDate()).thenReturn(now)

            account.deposit(1000)

            verify(transactions).register(Transaction(date = now, amount = 1000, balance = 1000))
        }

    }

})