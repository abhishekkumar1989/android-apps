package com.abhishek_k.todoapp.model;

import java.util.Date;
import java.util.UUID;

public class Todo {

    private UUID id = UUID.randomUUID();
    private String task;
    private Date dueOn = new Date();
    private boolean isCompleted;
    private String assignedTo;

    public Todo() {
    }

    public Todo(String task) {
        this.task = task;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getTask() {
        return task;
    }

    public Date getDueOn() {
        return dueOn;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public UUID getId() {
        return id;
    }

}
