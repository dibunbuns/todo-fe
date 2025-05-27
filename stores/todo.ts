export const useTodoStore = defineStore('todo', () => {
    type TodoItem = {
        id: string,
        name: string
    }

    const todoList = ref<TodoItem[]>([]);

    function addItem(name: string) {
        const uuid = self.crypto.randomUUID().toString();
        const item: TodoItem = {id: uuid, name: name};
        todoList.value.push(item);
    }

    return {
        todoList,
        addItem
    }
});
