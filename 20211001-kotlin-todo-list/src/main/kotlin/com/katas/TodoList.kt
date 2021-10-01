package com.katas

class TodoList(private val tasks: List<Task>) {

    fun totalDuration(): Int {
        return tasks.sumOf(Task::duration)
    }
}
