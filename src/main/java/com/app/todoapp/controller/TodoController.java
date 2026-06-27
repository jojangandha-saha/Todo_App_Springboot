package com.app.todoapp.controller;


import com.app.todoapp.models.Todo;
import com.app.todoapp.services.TodoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoServices todoServices;

    public TodoController(TodoServices todoServices) {
        this.todoServices = todoServices;
    }

    @GetMapping
    public List<Todo> getTodos() {
         return todoServices.getAllTodos();

    }
    //create a new Todo list
    @PostMapping
    public ResponseEntity<String> createTodo(@RequestBody  Todo todo) {
      todoServices.createTodo(todo);
        return ResponseEntity.ok("New Todo list item created successfully");

    }

    //delete all todos
    @DeleteMapping
    public ResponseEntity<String> deleeteAllTodos(){
         todoServices.deleteAllTodos();
         return ResponseEntity.ok("All todos deleted successfully");
    }

}
