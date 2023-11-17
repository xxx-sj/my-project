<template>
  <div class="tab-wrap">
    <section class="tab-section">
      <div v-for="tab in tabs" :key="tab" class="tab-item">
        <div @click="activeTab(tab.grid)">{{tab.name}}</div>
      </div>
    </section>
  </div>
</template>

<script>
  export default {
    name: 'c-tab',

    data() {
      return {
        tabs: [
            {id: 1, name:"tab1", grid: 'one'},
            {id: 2, name: "tab2", grid: 'two'},
            {id: 3, name: "tab3", grid: 'three'}
        ]
      }
    },

    methods: {
      activeTab(grid) {
        this.$emit("changeGrid", grid);
      }
    },


  }
</script>


<style scoped>

.tab-section {
  display: flex;
  justify-content: space-between;
  cursor: pointer;
}
</style>