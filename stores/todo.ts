export const useTodoStore = defineStore("todo", () => {
  type TodoItem = {
    id: string;
    name: string;
  };

  const todoList = ref<TodoItem[]>([]);

  function addItem(name: string) {
    const uuid = self.crypto.randomUUID();
    const item: TodoItem = { id: uuid, name: name };
    todoList.value.push(item);
  }

  function deleteItem(id: string) {
    todoList.value = todoList.value.filter((item) => item.id != id);
    // grabs everything in array that doesn't match id, then reassigns those items to the todolist
  }

  function editItem(id: string, edit: string) {
    let todoItem = todoList.value.find((item) => item.id === id)
    console.log(todoItem)
    let newItem = "hi";
    // goal: in place editing
  }

  return {
    todoList,
    addItem,
    deleteItem,
    editItem,
  };
});
