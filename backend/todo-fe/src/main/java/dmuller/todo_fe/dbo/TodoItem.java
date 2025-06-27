package dmuller.todo_fe.dbo;

import java.time.LocalDateTime;

public class TodoItem {

    private long id;
    private LocalDateTime dateAdded;
    private String name;
    private String description;
    private LocalDateTime dateCompleted;
    private Boolean completed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCompleted() {
        return dateCompleted;
    }

    public void setDate_completed(LocalDateTime dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
