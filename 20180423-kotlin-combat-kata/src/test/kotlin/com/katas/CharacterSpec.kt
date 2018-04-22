package com.katas

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object CharacterSpec : Spek({

    describe("Character") {

        lateinit var character: Character
        val anotherCharacter = Character()

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

        context("when dealing damage") {

            it("can receive damage from another Character") {
                anotherCharacter.damage(character, 400)

                assertThat(character.health).isEqualTo(600)
            }

            it("dies when damage received exceeds current Health") {
                anotherCharacter.damage(character, 1100)

                assertThat(character.health).isEqualTo(0)
                assertThat(character.isAlive).isFalse()
            }

            it("cannot damage itself") {
                assertThatThrownBy {
                    character.damage(character, 400)
                }.isExactlyInstanceOf(CannotDamageItself::class.java)
            }

            it("damage reduced by 50% when receiver level is 5 or more above the attacker") {
                val character = Character(level = 6)

                anotherCharacter.damage(character, 200)

                assertThat(character.health).isEqualTo(900)
            }

        }

        context("when healing") {

            it("can be healed") {
                val character = Character(health = 600)
                character.heal(character, 200)

                assertThat(character.health).isEqualTo(800)
            }

            it("cannot be healed above 1000 of Health") {
                character.heal(character, 200)

                assertThat(character.health).isEqualTo(1000)
            }

            it("cannot be healed when is dead") {
                val character = Character(isAlive = false)

                assertThatThrownBy {
                    character.heal(character, 200)
                }.isExactlyInstanceOf(CannotHealDeadWhenDead::class.java)
            }

            it("cannot heal other Characters") {
                assertThatThrownBy {
                    character.heal(anotherCharacter, 100)
                }.isExactlyInstanceOf(CannotHealOthers::class.java)
            }

        }

    }

})