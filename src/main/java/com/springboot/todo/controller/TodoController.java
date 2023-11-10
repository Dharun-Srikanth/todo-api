package com.springboot.todo.controller;

import com.springboot.todo.model.Todo;
import com.springboot.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/todo/api")
public class TodoController {

    @Autowired
    private TodoRepository repository;

    @GetMapping("/all")
    public List<Todo> showAllTodos(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Todo showTodo(@PathVariable int id){
        return repository.findById(id);
    }

    @PostMapping("/new-todo")
    public List<Todo> addNewTodo(@RequestBody Todo todo){
        repository.addTodo(todo);
        return repository.findAll();
    }

    @PutMapping("/updated-todo")
    public List<Todo> updateTodo(@RequestBody Todo todo){
        repository.updateTodo(todo);
        return repository.findAll();
    }

    @DeleteMapping("/after-delete/{id}")
    public List<Todo> deleteTodo(@PathVariable int id){
        repository.deleteTodo(id);
        return repository.findAll();
    }
}
