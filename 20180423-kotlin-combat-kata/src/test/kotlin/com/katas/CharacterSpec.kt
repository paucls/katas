package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object CharacterSpec : Spek({

    describe("Character") {

        val character = Character()

        describe("on creation") {

            it("starts with Health 1000") {
                assertThat(character.health).isEqualTo(1000)
            }

            it("starts with Level 1") {
                assertThat(character.level).isEqualTo(1)
            }

            it("starts alive") {
                assertThat(character.isAlive).isTrue()
            }

        }

    }

})