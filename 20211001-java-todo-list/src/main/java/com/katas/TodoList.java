package com.katas;

import java.util.Arrays;
import java.util.List;

public class TodoList {
    private final List<Task> tasks;

    public TodoList(Task... tasks) {
        this.tasks = Arrays.asList(tasks);
    }

    public Integer totalDuration() {
        return tasks.stream()
                .mapToInt(Task::getDuration)
                .sum();
    }
}
