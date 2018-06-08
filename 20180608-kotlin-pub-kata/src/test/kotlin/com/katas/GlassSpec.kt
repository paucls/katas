package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object GlassSpec : Spek({

    describe("PintGlass") {

        it("should be empty when is fresh") {
            val freshGlass = PintGlass()

            assertThat(freshGlass.isEmpty()).isTrue()
        }
    }

    describe("Bartender") {

        it("can fill a pint glass") {
            val bartender = Bartender()

            val freshGlass = PintGlass()
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
        return when (glass) {
            is HalfGlass -> HalfGlass(10)
            is PintGlass -> PintGlass(20)
        }
    }
}

sealed class Glass(val amount: Number = 0) {
    fun isEmpty(): Boolean = (amount == 0)

    fun howFull(): Number {
        return amount
    }

}

class PintGlass(amount: Number = 0) : Glass(amount)

class HalfGlass(amount: Number = 0) : Glass(amount)

