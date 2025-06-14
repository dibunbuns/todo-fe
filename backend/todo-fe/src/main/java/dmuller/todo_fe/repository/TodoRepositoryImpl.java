package dmuller.todo_fe.repository;

import dmuller.todo_fe.dbo.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepositoryImpl implements TodoRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addTodoItem(TodoItem todoItem) {
        String  insertItemSql = "INSERT INTO todo (name, description) VALUES (?, ?)";
        return jdbcTemplate.update(insertItemSql, todoItem.getName(), todoItem.getDescription());
    }

    @Override
    public List<TodoItem> getAllTodoItems() {
        String getAllTodoItemsSql = "SELECT * FROM todo";
        return jdbcTemplate.query(getAllTodoItemsSql, new BeanPropertyRowMapper<>(TodoItem.class));
    }

    @Override
    public TodoItem getTodoItem(long id) {
        String getItemByIdSql = "SELECT * FROM todo WHERE id = ?";
        return jdbcTemplate.queryForObject(getItemByIdSql, new BeanPropertyRowMapper<>(TodoItem.class), id);
    }

    @Override
    public int updateTodoItem(TodoItem todoItem) {
        String updateItemSql = "UPDATE todo SET name = ?, description = ? WHERE id = ?";
        return jdbcTemplate.update(updateItemSql, todoItem.getName(), todoItem.getDescription(), todoItem.getId());
    }

    @Override
    public int removeTodoItem(long id) {
        String removeItemSql = "DELETE FROM todo WHERE id = ?";
        return jdbcTemplate.update(removeItemSql, id);
    }

    @Override
    public int completeTodoItem(long id) {
        String completeItem = "UPDATE todo SET completed = ? WHERE id = ?";
        return jdbcTemplate.update(completeItem, id);
    }
}
