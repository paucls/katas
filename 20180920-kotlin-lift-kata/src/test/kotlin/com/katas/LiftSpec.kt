package com.katas

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.inOrder
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object LiftSpec : Spek({

    lateinit var display: Display

    beforeEachTest {
        display = mock()
    }

    describe("Lift") {
        it("should not move if already in requested floor") {
            val lift = Lift(display, 0)

            lift.request(0, Direction.UP)

            verify(display, never()).show(any())
        }

        it("should attend request moving up") {
            val lift = Lift(display, 0)

            lift.request(1, Direction.UP)

            verify(display).show("Floor: 1")
            assertThat(lift.floor).isEqualTo(1)
        }

        it("should attend request moving down") {
            val lift = Lift(display, 2)

            lift.request(1, Direction.DOWN)

            verify(display).show("Floor: 1")
            assertThat(lift.floor).isEqualTo(1)
        }

        it("should indicate current floor moving up") {
            val lift = Lift(display, 0)

            lift.request(2, Direction.UP)

            val inOrder = inOrder(display)
            inOrder.verify(display).show("Floor: 1")
            inOrder.verify(display).show("Floor: 2")
            assertThat(lift.floor).isEqualTo(2)
        }

        it("should indicate current floor moving down") {
            val lift = Lift(display, 2)

            lift.request(0, Direction.DOWN)

            val inOrder = inOrder(display)
            inOrder.verify(display).show("Floor: 1")
            inOrder.verify(display).show("Floor: 0")
            assertThat(lift.floor).isEqualTo(0)
        }
    }

})
