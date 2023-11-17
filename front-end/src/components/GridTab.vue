<template>
  <div>
    <p v-if="activeData">
      {{activeData.one}}
      {{activeData.two}}
      {{activeData.three}}
    </p>
  </div>
</template>

<script >
  export default {

    name: 'Grid-tab',

    props: {
      gridData: {
        type: String,
      },
    },

    watch: {
      gridData: function(val, _) {
        console.log({val}); //activeGrid
        const requestUrl = this.requestUrl[val];
        this.getData(requestUrl);
      }
    },


    data() {
      return {
        requestUrl: {
          one: "http://localhost:8080/one",
          two: "http://localhost:8080/two",
          three: "http://localhost:8080/three",
        },

        tempData: {
          one: {one: "one", two: "two", three: "three"},
          two: {one: "four", two: "five", three: "six"},
          three: {one: "seven", two: "eight", three: "nine"}
        },

        activeData: null,
      }
    },

    methods: {
      getData(url) {
        console.log({url});

        //fetch..

        //temp
        this.activeData = this.tempData[this.gridData];
      },
    }

  }
</script>


<style scoped>

</style>