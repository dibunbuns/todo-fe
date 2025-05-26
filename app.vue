<script setup>
const input = ref('empty');

function submit(){
  alert(input.value);
}
</script>

<template>
  <div>
    <input type="text" v-model="input">
    <p>{{ input }}</p>
    <button @click="submit">submit</button>
  </div>
</template>
