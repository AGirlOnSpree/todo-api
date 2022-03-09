package com.learn.springboot.microservice.todoapi.services;

import com.learn.springboot.microservice.todoapi.model.Task;
import com.learn.springboot.microservice.todoapi.repositories.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return new ArrayList<>(taskRepository.findAll());
    }

    public Task getTaskById(int id) {
        if (taskRepository.findById(id).isPresent())
            return taskRepository.findById(id).get();
        return new Task();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
}
