package dmuller.todo_fe.service;

import dmuller.todo_fe.dbo.TodoItem;
import dmuller.todo_fe.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> getAllItems() {
        return todoRepository.findAll();
    }
    
}
