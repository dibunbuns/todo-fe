export const useTodoStore = defineStore('todo', ()=>{
    const input = ref('empty');
    function submit(){
        alert(input.value);
    }
    return{
        input,
        submit
    }
});
