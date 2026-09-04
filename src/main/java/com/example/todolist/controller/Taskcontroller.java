package com.example.todolist.controller;

import com.example.todolist.model.Task;
import com.example.todolist.service.Taskservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class Taskcontroller {
    private Taskservice taskservice;

    @Autowired
    public Taskcontroller(Taskservice taskservice) {this.taskservice=taskservice;}

    @GetMapping
    public List<Task> getAllTask() {return taskservice.getAllTasks();}

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskservice.addTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task taskDetails) {
        return taskservice.updateTask(id, taskDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id) {
        boolean deleted=taskservice.deleteTask(id);
        if (deleted) {
            return "Da xoa: "+id;
        }
        else {
            return "ko tim dc: "+id;
        }
    }
}
