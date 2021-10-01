package com.katas;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TodoListTest {

    private TodoList todoList;

    @Test
    public void total_duration_of_empty_list() {
        todoList = new TodoList();

        assertThat(todoList.totalDuration()).isZero();
    }

    @Test
    public void total_duration_of_list_with_one_task() {
        todoList = new TodoList(aTaskWithDuration(5));

        assertThat(todoList.totalDuration()).isEqualTo(5);
    }

    @Test
    public void total_duration_of_list_with_multiple_tasks() {
        todoList = new TodoList(aTaskWithDuration(3), aTaskWithDuration(5));

        assertThat(todoList.totalDuration()).isEqualTo(8);
    }

    private Task aTaskWithDuration(int duration) {
        return new Task(duration);
    }
}
