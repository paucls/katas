package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object GlassSpec : Spek({

    describe("Glass") {

        it("should be empty when is fresh") {
            val freshGlass = Glass()

            assertThat(freshGlass.isEmpty).isTrue()
        }

        it("should contain 20 fl.oz when is served") {
            val freshGlass = Glass()
            val fullGlass = freshGlass.fill()
            assertThat(fullGlass.howFull()).isEqualTo(20)
        }
    }

})

class Glass(val isEmpty: Boolean = true) {
    fun fill(): Glass {
        return Glass()
    }

    fun howFull(): Number {
        return 20
    }
}