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

    @PostMapping("/items")
    public int addItem(@RequestBody TodoItem item) {
        return todoRepository.addTodoItem(item);
    }

    @GetMapping("/items")
    public List<TodoItem> getItems() {
        System.out.println("HIT ALL ITEMS");
        return todoRepository.getAllTodoItems();
    }

    @GetMapping("/items/{id}")
    public TodoItem getItem(@PathVariable("id") long id) {
        System.out.println("HIT ITEM ID: " + id);
        return todoRepository.getTodoItem(id);
    }

    @PutMapping("/items")
    public int updateItem(@RequestBody TodoItem item) {
        return todoRepository.updateTodoItem(item);
    }

    @DeleteMapping("/items/{id}")
    public int deleteItem(@PathVariable("id") long id) {
        return todoRepository.removeTodoItem(id);
    }

    @PutMapping("/items/{id}")
    public int completeItem(@PathVariable("id") long id) {
        return todoRepository.completeTodoItem(id);
    }

}
