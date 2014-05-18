package com.abhishek_k.todoapp;

import android.content.Context;

import com.abhishek_k.todoapp.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TodoManager {

    private Context appContext;
    private List<Todo> todos = new ArrayList<Todo>();
    private static TodoManager todoManager;

    public TodoManager(Context context) {
        appContext = context;
        populateTodos();
    }

    private void populateTodos() {
        for (int i = 0; i < 50; i++) {
            Todo todo = new Todo("Todo No. " + i);
            if (i % 2 == 0) todo.setCompleted(true);
                todos.add(todo);
        }
    }

    public static TodoManager get(Context context) {
        if (todoManager == null) todoManager = new TodoManager(context);
        return todoManager;
    }

    public void add(Todo todo) {
        todos.add(todo);
    }

    public void remove(Todo todo) {
        todos.remove(todo);
    }

    public void get(int position) {
        todos.get(position);
    }

    public Todo get(UUID id) {
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId().equals(id))
                return todos.get(i);
        }
        return null;
    }

    public List<Todo> getTodos() {
        return todos;
    }
}
