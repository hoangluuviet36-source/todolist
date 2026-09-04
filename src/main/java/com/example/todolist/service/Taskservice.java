package com.example.todolist.service;

import com.example.todolist.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Taskservice {
    private final List<Task> taskList = new ArrayList<>();

    public Taskservice() {
        taskList.add(new Task("1", "Học Spring Boot", "Làm quen cấu trúc cơ bản", false));
        taskList.add(new Task("2", "Làm bài tập lớn", "Hoàn thành TodoList", true));
    }

    public List<Task> getAllTasks() {
        return taskList;
    }

    public Task addTask(Task task) {
        taskList.add(task);
        return task;
    }

    public Task updateTask(String id, Task taskDetails) {
        for (Task task : taskList) {
            if (task.getId().equals(id)) {
                task.setTitle(taskDetails.getTitle());
                task.setDescription(taskDetails.getDescription());
                task.setStatus(taskDetails.isStatus());
                return task;
            }
        }
        return null;
    }

    public boolean deleteTask(String id) {
        return taskList.removeIf(task -> task.getId().equals(id));
    }
}
