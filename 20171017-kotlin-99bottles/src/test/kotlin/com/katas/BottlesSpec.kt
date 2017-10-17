package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object BottlesSpec : Spek({

    describe("99 Bottles Song") {

        val bottles = Bottles()

        it("first verse") {
            assertThat(bottles.verse(99)).isEqualTo("""
                99 bottles of beer on the wall, 99 bottles of beer.
                Take one down and pass it around, 98 bottles of beer on the wall.
            """.trimIndent())
        }

        it("another verse") {
            assertThat(bottles.verse(89)).isEqualTo("""
                89 bottles of beer on the wall, 89 bottles of beer.
                Take one down and pass it around, 88 bottles of beer on the wall.
            """.trimIndent())
        }

        it("verse 2") {
            assertThat(bottles.verse(2)).isEqualTo("""
                2 bottles of beer on the wall, 2 bottles of beer.
                Take one down and pass it around, 1 bottle of beer on the wall.
            """.trimIndent())
        }

        it("verse 1") {
            assertThat(bottles.verse(1)).isEqualTo("""
                1 bottle of beer on the wall, 1 bottle of beer.
                Take it down and pass it around, no more bottles of beer on the wall.
            """.trimIndent())
        }

        it("verse 0") {
            assertThat(bottles.verse(0)).isEqualTo("""
                No more bottles of beer on the wall, no more bottles of beer.
                Go to the store and buy some more, 99 bottles of beer on the wall.
            """.trimIndent())
        }

    }

})