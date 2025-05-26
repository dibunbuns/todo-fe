<script setup>
const todoStore = useTodoStore();
</script>

<template>
  <div>
    <input type="text" v-model="todoStore.input">
    <p>{{ todoStore.input }}</p>
    <button @click="todoStore.submit">submit</button>
  </div>
</template>
