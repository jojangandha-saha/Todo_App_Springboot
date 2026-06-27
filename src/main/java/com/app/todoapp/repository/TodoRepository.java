package com.app.todoapp.repository;

import com.app.todoapp.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

//interact with db
//entity and type of primary key
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
