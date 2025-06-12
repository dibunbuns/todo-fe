package dmuller.todo_fe.dbo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo")
public class TodoItem {
    @Id
    private long id;
    @Column(name = "date_added")
    private LocalDateTime dateAdded;
    private String name;
    private String description;
    @Column(name = "date_completed")
    private LocalDate dateCompleted;
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

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDate_completed(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
