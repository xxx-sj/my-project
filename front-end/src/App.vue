<template>
  <div class="wrap">
    <c-tab @change-grid="changeGrid"/>
    <grid-tab :grid-data="activeGrid"/>
  </div>
</template>

<script>

import GridTab from "@/components/GridTab.vue";
import CTab from "@/components/Ctab.vue";
export default {
  name: 'App',
  components: {
    CTab,
    GridTab
  },

  data() {
    return {
      activeGrid: null,
    }
  },

  methods: {
    changeGrid(grid) {
      this.activeGrid = grid;
    }
  }

}
</script>

<style>
</style>
