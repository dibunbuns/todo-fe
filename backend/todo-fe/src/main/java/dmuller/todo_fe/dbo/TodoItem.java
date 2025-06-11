package dmuller.todo_fe.dbo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TodoItem {
    @Id
    private long id;
    private Long date_added;
    private String name;
    private String description;
    private Long date_completed;
    private Boolean completed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getDate_added() {
        return date_added;
    }

    public void setDate_added(Long date_added) {
        this.date_added = date_added;
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

    public Long getDate_completed() {
        return date_completed;
    }

    public void setDate_completed(Long date_completed) {
        this.date_completed = date_completed;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
