package com.katas

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object LiftSpec : Spek({

    val display: Display = mock()

    describe("Lift") {
        it("should not move if already in requested floor") {
            val lift = Lift(display, 0)

            lift.request(0, Direction.UP)

            verify(display, never()).show(any())
        }

        it("should move up") {
            val lift = Lift(display, 0)

            lift.request(1, Direction.UP)

            verify(display).show("Floor: 1")
            assertThat(lift.floor).isEqualTo(1)
        }
    }

})
