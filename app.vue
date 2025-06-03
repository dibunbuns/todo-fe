<script setup lang="ts">
const todoStore = useTodoStore();
const input = ref("laundry....");
const edit = ref('');
const editField = ref(false);

function enableEdit(id: string) {
  document.getElementById(id)!.disabled = false;
}
</script>

<template>
  <div>
    <input type="text" v-model="input" />
    <button @click="todoStore.addItem(input)">submit</button>

    <p v-for="item in todoStore.todoList" :key="item.id">
      <input :id="item.id" disabled :value="item.name" />
      <button @click="todoStore.deleteItem(item.id)">delete</button>
      <button
        @click="
          todoStore.editItem(item.id, edit);
          enableEdit(item.id);
        "
      >
        edit
      </button>
    </p>
  </div>
</template>
