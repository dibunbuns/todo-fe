export type TodoItem = {
  id: number;
  name: string;
};

export const useTodoStore = defineStore("todo", () => {
  const todoList = ref<TodoItem[]>([]);
  const config = useRuntimeConfig();

  async function showItems() {
    const res = await fetch(`${config.public.apiBase}/items`);
    if (!res.ok) {
      throw new Error(`Response status: ${res.status}`);
    }
    const data = await res.json();
    todoList.value = data;
  }

  async function addItem(item: String) {
    console.log("hellow add item");
    console.log(item)
    const res = await fetch(`${config.public.apiBase}/items`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(item),
    });
    console.log(item)
    if (!res.ok) {
      throw new Error(`Response status: ${res.status}`);
    }
    return res;

    // const uuid = self.crypto.randomUUID();
    // const item: TodoItem = { id: uuid, name: name };
    // todoList.value.push(item);
  }

  function deleteItem(id: number) {
   
    // grabs everything in array that doesn't match id, then reassigns those items to the todoList
  }

  function editItem(item: TodoItem) {
    const todoItem = todoList.value.find((i) => i.id === item.id);
    if (todoItem) {
      todoItem.name = item.name;
    }
    console.log(todoItem);
  }

  return {
    todoList,
    addItem,
    deleteItem,
    editItem,
    showItems,
  };
});
