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
        String name = item.getName();
        return todoRepository.addTodoItem(name);
    }

    @GetMapping("/items")
    public List<TodoItem> getItems() {
        return todoRepository.getAllTodoItems();
    }

    @GetMapping("/items/{id}")
    public TodoItem getItem(@PathVariable long id) {
        return todoRepository.getTodoItem(id);
    }

    @PutMapping("/items")
    public int updateItem(@RequestBody TodoItem item) {
        return todoRepository.updateTodoItem(item);
    }

    @DeleteMapping("/items/{id}")
    public int deleteItem(@PathVariable Long id) {
        return todoRepository.removeTodoItem(id);
    }

    @PutMapping("/items/{id}")
    public int completeItem(@PathVariable long id, @RequestBody boolean status) {
        return todoRepository.completeTodoItem(id, status);
    }

}
