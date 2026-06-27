package com.app.todoapp.services;


import com.app.todoapp.models.Todo;
import com.app.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServices {
    private final TodoRepository todoRepository;

    public TodoServices(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        //fetch the todos from db
        return todoRepository.findAll();
    }

    public Todo createTodo(Todo todo){

        //todo.setTitle(title);
        todo.setCompleted(false);
        //save to db
        return todoRepository.save(todo);

    }

    public void deleteAllTodos() {
         todoRepository.deleteAll();
    }
}
