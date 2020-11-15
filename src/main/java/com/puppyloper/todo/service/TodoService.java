package com.puppyloper.todo.service;

import java.util.Date;
import java.util.Optional;

import com.puppyloper.todo.model.Todo;
import com.puppyloper.todo.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    public Todo createTodo(Todo todo) {
        todo.setIsDone(false);
        todo.setCreatedAt(new Date());
        todo.setUpdatedAt(new Date());
        Todo createdTodo = todoRepository.save(todo);
        return createdTodo;
    }

    @Transactional
    public Iterable<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Transactional
    public Optional<Todo> getTodo(Integer id) {
        return todoRepository.findById(id);
    }

    @Transactional
    public Todo updateTodo(Todo todo) {
        todo.setUpdatedAt(new Date());
        return todoRepository.save(todo);
    }

    @Transactional
    public Todo deleteTodo(Integer id) {
        Optional<Todo> maybeTodo = todoRepository.findById(id);
        if (maybeTodo.isEmpty()) {
            return null;
        }
        Todo todo = maybeTodo.get();
        todoRepository.delete(todo);
        return todo;

    }
}