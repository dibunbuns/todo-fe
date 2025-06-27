<script setup lang="ts">
const todoStore = useTodoStore();
const input = ref("");
const editItem = ref<TodoItem | undefined>();
onMounted(() => {
  todoStore.showItems();
});
</script>

<template>
  <div class="app">
    <div class="list">
      <input type="text" v-model="input" @keypress.enter="todoStore.addItem(input)"/>
      <button @click="todoStore.addItem(input)">submit</button>

      <p
        v-for="item in todoStore.todoList"
        :key="item.id"
        :class="{ completed: item.completed }"
      >
        {{ item.name }}
        <button @click="todoStore.deleteItem(item.id)">delete</button>
        <button @click="editItem = item">edit</button>
        <button
          @click="
            todoStore.completeItem(item.id, !item.completed),
              todoStore.toggleComplete(item.id)
          "
        >
          {{ item.completed ? "Undo" : "Done" }}
        </button>
      </p>
    </div>
    <div class="editForm">
      <EditForm
        v-if="editItem"
        :todoItem="editItem"
        @close="editItem = undefined"
      />
    </div>
  </div>
</template>

<style>
.app {
  width: 800px;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
}
.completed {
  text-decoration: line-through;
  color: grey;
  opacity: 0.7;
}
</style>
