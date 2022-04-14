package com.learn.springboot.microservice.todoapi.controllers;

import com.learn.springboot.microservice.todoapi.model.Task;
import com.learn.springboot.microservice.todoapi.services.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/todo-api/v1")
public class TodoController {

    @Autowired
    TaskService taskService;

    //Get all tasks
    @GetMapping("/task")
    public List<Task> getAllTasks() {
        log.info("Listing all the tasks");
        return taskService.getAllTasks();
    }

    //Get one task
    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable("id") int id) {
        log.info("Returning Task for task id : {}", id);
        return taskService.getTaskById(id);
    }

    //Add a task
    @PostMapping("/task")
    public Task addTask(@RequestBody Task task) {
        log.info("Adding a task to the To-Do");
        return taskService.addTask(task);
    }

    //Delete a task
    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable("id") int id) {
        log.info("Deleting task for id : {}", id);
        taskService.deleteTask(id);
    }

    //Mark a task as Complete
    @PutMapping("/task/{id}")
    public Task updateTaskToComplete(@RequestBody Task task) {
        log.info("Marking Task {} as done", task.getId());
        return taskService.updateTask(task);
    }
}
