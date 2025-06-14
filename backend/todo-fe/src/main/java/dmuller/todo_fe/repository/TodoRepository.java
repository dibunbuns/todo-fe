package dmuller.todo_fe.repository;

import dmuller.todo_fe.dbo.TodoItem;

import java.util.List;

public interface TodoRepository {
    int addTodoItem(TodoItem todoItem);
    List<TodoItem> getAllTodoItems();
    TodoItem getTodoItem(long id);
    int updateTodoItem(TodoItem todoItem);
    int removeTodoItem(long id);
    int completeTodoItem(long id);
}
