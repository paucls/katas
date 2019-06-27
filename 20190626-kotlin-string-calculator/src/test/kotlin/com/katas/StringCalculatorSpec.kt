package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object StringCalculatorSpec : Spek({

    describe("Add operation") {
        it("should return 0 when string empty") {
            assertThat(StringCalculator().add("")).isEqualTo(0)
        }

        it("should return number when string contains single number") {
            assertThat(StringCalculator().add("1")).isEqualTo(1)
        }

        it("should return sum of numbers when string contains multiple numbers") {
            assertThat(StringCalculator().add("1,2")).isEqualTo(3)
        }

        it("should return sum of numbers when string contains multiple numbers separated by new lines") {
            assertThat(StringCalculator().add("1\n2,3")).isEqualTo(6)
        }

        it("should support different delimiter") {
            assertThat(StringCalculator().add("//;\n1;2")).isEqualTo(3)
        }
    }

})