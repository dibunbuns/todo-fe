<script setup lang="ts">
const todoStore = useTodoStore();
const props = defineProps({
  todoItem: {
    type: Object as PropType<TodoItem>,
    required: true,
  },
});
const newInput = ref({ ...props.todoItem });
</script>

<template>
  <div>
    <h3>Edit {{ todoItem.name }}</h3>
    <input
      type="text"
      v-model="newInput.name"
      @keypress.enter="todoStore.editItem(newInput), $emit('close')"
    />
    <button
      @click="
        todoStore.editItem(newInput);
        $emit('close');
      "
    >
      Save
    </button>
    <button @click="$emit('close')">Cancel</button>
  </div>
</template>
