package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object AccountSpec : Spek({

    describe("Account") {
        it("should print statement") {
            val account = Account()

            assertThat(account.printStatement()).isEqualTo("Date    Amount  Balance")
        }
    }

})
