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

    describe("printStatement") {

        val dateProviderMock = mock(DateProvider::class.java)

        given("client didn't make any transaction") {
            it("prints a empty statement") {
                val account = Account(dateProviderMock)

                assertThat(account.printStatement()).isEqualTo("Date  Amount  Balance")
            }
        }

        given("client made a deposit") {
            it("prints a statement containing the deposit") {
                val account = Account(dateProviderMock)
                `when`(dateProviderMock.currentDate()).thenReturn(LocalDate.of(2015, 12, 24))

                account.deposit(500)

                assertThat(account.printStatement()).isEqualTo("""
                    Date  Amount  Balance
                    24/12/2015  +500  500
                    """.trimIndent())
            }
        }

    }

})
