package dmuller.todo_fe.controller;

import dmuller.todo_fe.dbo.TodoItem;
import dmuller.todo_fe.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/todo-app")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/items")
    public List<TodoItem> getAllItems() {
        return service.getAllItems();
    }
    
    
}
