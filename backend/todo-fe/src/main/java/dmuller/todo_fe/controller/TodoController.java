package dmuller.todo_fe.controller;

import dmuller.todo_fe.dbo.TodoItem;
import dmuller.todo_fe.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @PostMapping("/item")
    public int addItem(@RequestBody TodoItem item) {
        return todoRepository.addTodoItem(item);
    }

    @GetMapping("/items")
    public List<TodoItem> getItems() {
        return todoRepository.getAllTodoItems();
    }

    @GetMapping("/item/{id}")
    public TodoItem getItem(@PathVariable("id") int id) {
        return todoRepository.getTodoItem(id);
    }

    @PutMapping("/item")
    public int updateItem(@RequestBody TodoItem item) {
        return todoRepository.updateTodoItem(item);
    }

    @DeleteMapping("/item/{id}")
    public int deleteItem(@PathVariable("id") int id) {
        return todoRepository.removeTodoItem(id);
    }

    @PutMapping("/item/{id}")
    public int completeItem(@PathVariable("id") int id) {
        return todoRepository.completeTodoItem(id);
    }
}
