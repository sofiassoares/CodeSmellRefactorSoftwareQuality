package org.example.studyplanner;

import java.text.MessageFormat;
import java.time.LocalDateTime;

public class ToDo implements PlannerMaterial {
    private Integer id; // no longer final to support setId() in tests
    private String title;
    private String description;
    private int priority;
    private boolean completed;
    private LocalDateTime completedAt;

    public ToDo(Integer id, String title, String description, int priority) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "[(Priority:{3}) ToDo {0}: {1}, {2} | Completed: {4}]",
                id, title, description, priority, completed ? "Yes" : "No"
        );
    }

    // === Behavioral methods ===

    public boolean isHighPriority() {
        return this.priority >= 8;
    }

    public void promotePriority() {
        if (this.priority < 10) {
            this.priority++;
        }
    }

    public void demotePriority() {
        if (this.priority > 1) {
            this.priority--;
        }
    }

    public void markAsCompleted() {
        this.completed = true;
        this.completedAt = LocalDateTime.now();
    }

    public void updateDescription(String newDescription) {
        if (newDescription != null && !newDescription.equals(this.description)) {
            this.description = newDescription;
        }
    }

    public void rename(String newTitle) {
        if (newTitle != null && !newTitle.isBlank()) {
            this.title = newTitle;
        }
    }

    // === Getters ===

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    // === Setters for testing compatibility ===

    public void setId(Integer id) {
        if (id == null || id < 0) {
            throw new IllegalArgumentException("ID must be a positive integer");
        }
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
