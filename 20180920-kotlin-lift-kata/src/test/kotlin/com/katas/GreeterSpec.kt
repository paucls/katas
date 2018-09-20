package com.katas

import com.nhaarman.mockito_kotlin.inOrder
import com.nhaarman.mockito_kotlin.mock
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object GreeterSpec : Spek({

    describe("Lift") {
        it("should respond to calls containing a source floor and direction") {
            val display: Display = mock()
            val currentFloor = 0
            val lift = Lift(display, currentFloor)

            val floor = 3
            val direction = "up"
            lift.request(floor, direction)

            val inOrder = inOrder(display)
            inOrder.verify(display).show("Floor: 1")
            inOrder.verify(display).show("Floor: 2")
            inOrder.verify(display).show("Floor: 3")
        }
    }

})

