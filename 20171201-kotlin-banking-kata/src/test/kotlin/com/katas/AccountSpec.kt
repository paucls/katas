package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.time.LocalDate

object AccountSpec : Spek({

    lateinit var dateProviderMock: DateProvider
    lateinit var statementPresenter: PrintStatementPresenter
    lateinit var account: Account

    beforeEachTest {
        dateProviderMock = mock(DateProvider::class.java)
        statementPresenter = PrintStatementPresenter()
        account = Account(dateProviderMock, statementPresenter)
    }

    describe("printStatement") {

        given("client didn't make any transaction") {
            it("prints a empty statement") {
                assertThat(account.printStatement()).isEqualTo("Date  Amount  Balance")
            }
        }

        given("client made a deposit") {
            it("prints a statement containing the deposit") {
                `when`(dateProviderMock.currentDate()).thenReturn(LocalDate.of(2017, 10, 5))

                account.deposit(500)

                assertThat(account.printStatement()).isEqualTo("""
                    Date  Amount  Balance
                    05/10/2017  +500  500
                    """.trimIndent())
            }
        }

        given("client made multiple deposits") {
            it("prints a statement containing deposits and calculates balance") {
                `when`(dateProviderMock.currentDate()).thenReturn(LocalDate.of(2015, 12, 24))

                account.deposit(500)
                account.deposit(300)
                account.deposit(50)

                assertThat(account.printStatement()).isEqualTo("""
                    Date  Amount  Balance
                    24/12/2015  +500  500
                    24/12/2015  +300  800
                    24/12/2015  +50  850
                    """.trimIndent())
            }
        }

        given("client made a deposit and a withdraw") {
            it("prints a statement containing the deposit and withdraw") {
                `when`(dateProviderMock.currentDate()).thenReturn(LocalDate.of(2017, 10, 5))
                account.deposit(500)

                `when`(dateProviderMock.currentDate()).thenReturn(LocalDate.of(2017, 10, 6))
                account.withdraw(100)

                assertThat(account.printStatement()).isEqualTo("""
                    Date  Amount  Balance
                    05/10/2017  +500  500
                    06/10/2017  -100  400
                    """.trimIndent())
            }
        }

    }

})
