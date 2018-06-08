package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object GlassSpec : Spek({

    describe("Glass") {

        it("should be empty when is fresh") {
            val freshGlass = Glass()

            assertThat(freshGlass.isEmpty()).isTrue()
        }
    }

    describe("Bartender") {
        it("can fill a pint glass") {
            val bartender = Bartender()

            val freshGlass = Glass()
            val fullGlass = bartender.fill(freshGlass)

            assertThat(fullGlass.howFull()).isEqualTo(20)
            assertThat(fullGlass.isEmpty()).isFalse()
        }

        it("can fill a half-pint glass") {
            val bartender = Bartender()

            val freshGlass = HalfGlass()
            val fullGlass = bartender.fill(freshGlass)

            assertThat(fullGlass.howFull()).isEqualTo(10)
            assertThat(fullGlass.isEmpty()).isFalse()
        }
    }

})

class Bartender {
    fun fill(glass: Glass): Glass {
        when (glass) {
            is HalfGlass -> return HalfGlass(10)
        }

        return Glass(20)
    }

}

open class Glass(val amount: Number = 0) {

    fun isEmpty(): Boolean {
        return (amount == 0)
    }

    fun howFull(): Number {
        return amount
    }
}

class HalfGlass(amount: Number = 0) : Glass(amount)

