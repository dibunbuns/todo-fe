<script setup lang="ts">
const todoStore = useTodoStore();
const input = ref("laundry....");
</script>

<template>
  <div class="app">
    <div class="list">
      <input type="text" v-model="input" />
      <button @click="todoStore.addItem(input)">submit</button>

      <p v-for="item in todoStore.todoList" :key="item.id">
        {{ item.name }}
        <button @click="todoStore.deleteItem(item.id)">delete</button>
        <button>edit</button>
      </p>
    </div>
    <div class="editForm">
      <EditForm />
    </div>
  </div>
</template>

<style>
.app {
  width: 800px;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
}
</style>
