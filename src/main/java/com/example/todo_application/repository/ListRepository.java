package com.example.todo_application.repository;

import com.example.todo_application.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<TodoList, Integer> {
}
