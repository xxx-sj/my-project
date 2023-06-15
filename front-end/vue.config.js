const { defineConfig } = require('@vue/cli-service')

const host = "localhost";
const port = "8080";

module.exports = defineConfig({
  transpileDependencies: true,

  outputDir: "../back-end/src/main/resources/static",

  devServer: {
    hot: true,

    proxy: {
      //http://localhost:8081 -> http://localhost:8080
      '/api/': {
        // target: `http://${host}:${port}`,
        target: `http://localhost:8080`,
        changeOrigin: true,
      },

      '/ws/': {
        target: `ws://${host}:${port}`,
        changeOrigin: false,
        ws: true,
      }
    }
  }
})
