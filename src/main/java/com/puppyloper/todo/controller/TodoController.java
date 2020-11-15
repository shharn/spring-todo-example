package com.puppyloper.todo.controller;

import java.util.Optional;

import com.puppyloper.todo.model.Todo;
import com.puppyloper.todo.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping(path = "", consumes = { "application/json" }, produces = { "application/json" })
    public @ResponseBody Todo createTodo(@Validated @RequestBody Todo todo) {
        todo = todoService.createTodo(todo);
        return todo;
    }

    @GetMapping(path="", produces = {"application/json"})
    public @ResponseBody Iterable<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping(path="/{id}", produces = {"application/json"})
    public @ResponseBody Todo getTodo(@PathVariable("id") Integer id) {
        Optional<Todo> todo = todoService.getTodo(id);
        if (todo.isPresent()) {
            return todo.get();
        }
        return null;
    }

    @PatchMapping(path="/{id}", consumes={"application/json"}, produces={"application/json"})
    public @ResponseBody Todo updateTodo(@Validated @RequestBody Todo todo) {
        todo = todoService.updateTodo(todo);
        return todo;
    }

    @DeleteMapping(path="/{id}", produces={"application/json"})
    public @ResponseBody Todo deleteTodo(@PathVariable("id") Integer id) throws Exception {
        throw new Exception("test exception");
        // return todoService.deleteTodo(id);
    }
}