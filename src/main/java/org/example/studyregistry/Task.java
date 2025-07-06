package org.example.studyregistry;

import java.time.Duration;
import java.time.LocalDateTime;

public class Task extends Registry {
    private String title;
    private String description;
    private final String author;
    private LocalDateTime dueDate;
    private boolean completed = false;
    private LocalDateTime completedAt;

    public Task(String title, String description, String author, LocalDateTime dueDate) {
        setTitle(title); // still validates title
        this.description = description;
        this.author = author;
        this.dueDate = dueDate;
    }

    // ✅ Required for tests
    public String getTitle() {
        return title;
    }

    // ✅ Required for tests, includes validation
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title;
        this.name = title; // from Registry
    }

    // ✅ Required for tests
    public String getDescription() {
        return description;
    }

    // ✅ Required for tests
    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void reschedule(LocalDateTime newDate) {
        if (newDate.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Cannot set due date in the past.");
        }
        this.dueDate = newDate;
    }

    public boolean isOverdue() {
        return !completed && dueDate.isBefore(LocalDateTime.now());
    }

    public boolean isDueWithinHours(int hours) {
        return !completed &&
                dueDate.isAfter(LocalDateTime.now()) &&
                Duration.between(LocalDateTime.now(), dueDate).toHours() <= hours;
    }

    public void markCompleted() {
        if (completed) throw new IllegalStateException("Already completed.");
        completed = true;
        completedAt = LocalDateTime.now();
    }

    public void reopen() {
        if (!completed) throw new IllegalStateException("Task is not completed.");
        completed = false;
        completedAt = null;
    }

    public String summary() {
        String status = completed ? "Completed at " + completedAt : "Due " + dueDate;
        return String.format("Task: %s [%s] - %s", title, author, status);
    }
}
