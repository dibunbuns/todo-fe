<script setup lang="ts">
const todoStore = useTodoStore();
const input = ref('empty');

</script>

<template>
  <div>

    <input type="text" v-model="input">
    <p>{{ input }}</p>
    <button @click="todoStore.addItem(input)">submit</button>
    <p v-for="item in todoStore.todoList" :key="item.id">{{ item }}</p>
  </div>
</template>
