package com.katas

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class TodoListTest {
    @Test
    fun `total duration of empty list`() {
        val todoList = TodoList(listOf())

        assertThat(todoList.totalDuration()).isZero
    }

    @Test
    fun `total duration when one item`() {
        val todoList = TodoList(listOf(Task(duration = 5)))

        assertThat(todoList.totalDuration()).isEqualTo(5)
    }

    @Test
    fun `total duration when multiple items`() {
        val todoList = TodoList(listOf(Task(duration = 5), Task(duration = 3)))

        assertThat(todoList.totalDuration()).isEqualTo(8)
    }
}
