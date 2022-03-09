package com.learn.springboot.microservice.todoapi.repositories;

import com.learn.springboot.microservice.todoapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
