package com.app.todoapp.controller;


import com.app.todoapp.models.Todo;
import com.app.todoapp.services.TodoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    //read one todo list with id
    @GetMapping("/{id}")
    public Optional<Todo> getTodoById(@PathVariable long id) {
        return todoServices.getTodoById(id);
    }
    //create a new Todo list
    @PostMapping
    public ResponseEntity<String> createTodo(@RequestBody  Todo todo) {
      todoServices.createTodo(todo);
        return ResponseEntity.ok("New Todo list item created successfully");

    }
    //update existing todo
    @PutMapping("/{id}")
    public  ResponseEntity<String> updateTodo(@PathVariable long id, @RequestBody Todo todo) {
        todoServices.updateTodo(id, todo);
        return ResponseEntity.ok("Todo with given id " + id+ " updated successfully");
    }

    //delete one todo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleeteTodoById(@PathVariable long id) {
        todoServices.deleteTodoById(id);
        return ResponseEntity.ok("Todo with given id " + id+ " deleted successfully");
    }

    //delete all todos
    @DeleteMapping
    public ResponseEntity<String> deleeteAllTodos(){
         todoServices.deleteAllTodos();
         return ResponseEntity.ok("All todos deleted successfully");
    }


}
