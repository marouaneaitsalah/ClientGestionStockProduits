package com.example.todo.service;

import com.example.todo.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public Task create(Task task) {
        long id = idGenerator.getAndIncrement();
        Task newTask = new Task(id, task.getTitle(), task.getDescription(), task.isDone());
        tasks.put(id, newTask);
        return newTask;
    }

    public Task update(Long id, Task task) {
        Task existing = tasks.get(id);
        if (existing == null) {
            return null;
        }

        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setDone(task.isDone());
        return existing;
    }

    public boolean delete(Long id) {
        return tasks.remove(id) != null;
    }
}
