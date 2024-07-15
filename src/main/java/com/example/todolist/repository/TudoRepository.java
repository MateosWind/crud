package com.example.todolist.repository;

import com.example.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TudoRepository extends JpaRepository<Task, Long> {
}
