export type TodoItem = {
  id: number;
  name: string;
  completed: boolean;
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

  async function addItem(name: String) {
    const res = await fetch(`${config.public.apiBase}/items`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ name: name }),
    });
    if (!res.ok) {
      throw new Error(`Response status: ${res.status}`);
    }
    await showItems();
  }

  async function deleteItem(id: number) {
    const res = await fetch(`${config.public.apiBase}/items/${id}`, {
      method: "DELETE",
    });
    if (!res.ok) {
      throw new Error(`Response status: ${res.status}`);
    }
    await showItems();
  }

  async function editItem(item: TodoItem) {
    const res = await fetch(`${config.public.apiBase}/items`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(item),
    });
    await showItems();
  }

  async function completeItem(id: number, completed: boolean) {
    const res = await fetch(`${config.public.apiBase}/items/${id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(completed),
    });
    if (!res.ok) {
      throw new Error(`Response status: ${res.status}`);
    }
    await showItems();
  }

  function toggleComplete(id: number) {
    const item = todoList.value.find((i) => i.id === id);
    if (item) {
      item.completed = !item.completed;
    }
  }

  return {
    todoList,
    addItem,
    deleteItem,
    editItem,
    showItems,
    completeItem,
    toggleComplete,
  };
});
