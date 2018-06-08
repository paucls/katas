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

    }

})

class Glass(val isEmpty: Boolean = true)