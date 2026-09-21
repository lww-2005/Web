module.exports = {
  devServer: {
    port: 8082,
    proxy: {
      '/tijian': {
        target: 'http://10.206.99.225:8088',
        changeOrigin: true,
        ws: true
      }
    }
  }
}