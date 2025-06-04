<script setup lang="ts">
const todoStore = useTodoStore();
const props = defineProps({
  todoItem: {
    type: Object as PropType<TodoItem>,
    required: true,
  },
});
</script>
<template>
  <div>
    <h3>Edit {{ todoItem.name }}</h3>
    <input type="text" />
    <button
      @click="
        $emit('close');
      "
    >
      Save
    </button>
    <button @click="$emit('close')">Cancel</button>
  </div>
</template>
