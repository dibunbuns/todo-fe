<script setup lang="ts">
const todoStore = useTodoStore();
const input = ref('laundry....');

</script>

<template>
  <div>

    <input type="text" v-model="input">

    <button @click="todoStore.addItem(input)">submit</button>
    <p v-for="item in todoStore.todoList" :key="item.id">
      {{ item.id }}, {{ item.name }}
      <button @click="todoStore.deleteItem(item.id)">delete</button>
      <button>edit</button>
    </p>
  </div>
</template>
