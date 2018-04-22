package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object CharacterSpec : Spek({

    describe("Character") {

        lateinit var character: Character

        beforeEachTest {
            character = Character()
        }

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

        describe("dealing damage") {

            it("can receive damage from another Character") {
                character.receiveDamage(400)

                assertThat(character.health).isEqualTo(600)
            }

            it("dies when damage received exceeds current Health") {
                character.receiveDamage(1100)

                assertThat(character.health).isEqualTo(0)
                assertThat(character.isAlive).isFalse()
            }

        }

        describe("healing") {

            it("can be healed") {
                character.receiveDamage(400)
                character.receiveHeal(200)

                assertThat(character.health).isEqualTo(800)
            }

            it("cannot be healed above 1000 of Health") {
                character.receiveHeal(200)

                assertThat(character.health).isEqualTo(1000)
            }

            it("cannot be healed when is dead") {
                character.receiveDamage(1100)

                assertThatThrownBy {
                    character.receiveHeal(200)
                }.isExactlyInstanceOf(CannotHealDeadWhenDead::class.java)
            }

        }

    }

})