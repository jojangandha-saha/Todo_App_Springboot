package com.app.todoapp.services;


import com.app.todoapp.models.Todo;
import com.app.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

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
    
    public Optional<Todo> getTodoById(@RequestParam long id) {
        return todoRepository.findById(id);
    }

    public Todo createTodo(Todo todo){

        //todo.setTitle(title);
        todo.setCompleted(false);
        //save to db
        return todoRepository.save(todo);

    }
    public void updateTodo(long id, Todo todo){
      Optional<Todo> todoWithId =  todoRepository.findById(id);
      Todo existingTodo = todoWithId.get();
      existingTodo.setTitle(todo.getTitle());
     boolean todoStatus= todo.isCompleted();
      existingTodo.setCompleted((todoStatus));
        todoRepository.save(existingTodo);
    }


    public void deleteTodoById(@RequestParam long id){
        todoRepository.deleteById(id);
    }
    public void deleteAllTodos() {
         todoRepository.deleteAll();
    }
}
