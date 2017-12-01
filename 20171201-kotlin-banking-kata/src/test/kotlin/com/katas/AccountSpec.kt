package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

object AccountSpec : Spek({

    describe("printStatement") {

        given("client didn't make any operation") {
            it("prints a empty statement") {
                val account = Account()

                assertThat(account.printStatement()).isEqualTo("Date    Amount  Balance")
            }
        }

    }

})
