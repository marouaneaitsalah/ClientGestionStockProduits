package com.example.todo.model;

import jakarta.validation.constraints.NotBlank;

public class Task {

    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    private String title;

    private String description;

    private boolean done;

    public Task() {
    }

    public Task(Long id, String title, String description, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
