export type TodoItem = {
  id: string;
  name: string;
};

export const useTodoStore = defineStore("todo", () => {
  const todoList = ref<TodoItem[]>([]);

  function addItem(name: string) {
    const uuid = self.crypto.randomUUID();
    const item: TodoItem = { id: uuid, name: name };
    todoList.value.push(item);
  }

  function deleteItem(id: string) {
    todoList.value = todoList.value.filter((item) => item.id != id);
    // grabs everything in array that doesn't match id, then reassigns those items to the todoList
  }

  function editItem(item: TodoItem) {
    const todoItem = todoList.value.find((i) => i.id === item.id);
    if (todoItem) {
      todoItem.name = item.name;
    }
  }

  return {
    todoList,
    addItem,
    deleteItem,
    editItem,
  };
});
