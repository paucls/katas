package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

object AccountSpec : Spek({

    describe("printStatement") {

        given("client didn't make any transaction") {
            it("prints a empty statement") {
                val account = Account()

                assertThat(account.printStatement()).isEqualTo("Date  Amount  Balance")
            }
        }

        given("client made a deposit") {
            it("prints a statement containing the deposit") {
                val account = Account()

                account.deposit(500)

                assertThat(account.printStatement()).isEqualTo("""
                    Date  Amount  Balance
                    24/12/2015  +500  500
                    """.trimIndent())
            }
        }

    }

})
