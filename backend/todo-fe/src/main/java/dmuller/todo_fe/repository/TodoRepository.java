package dmuller.todo_fe.repository;

import dmuller.todo_fe.dbo.TodoItem;

import java.util.List;

public interface TodoRepository {
    int addTodoItem(String name);
    List<TodoItem> getAllTodoItems();
    TodoItem getTodoItem(long id);
    int updateTodoItem(TodoItem todoItem);
    int removeTodoItem(Long id);
    int completeTodoItem(long id, boolean status);
}
