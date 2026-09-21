<template>
  <div class="wrapper">
    <!-- 顶部导航 -->
    <header>
      <i class="fa fa-angle-left" @click="$router.back()"></i>
      <h2>我的体检报告</h2>
      <div></div>
    </header>

    <div class="content">
      <!-- 无图片空状态，不会报资源缺失 -->
      <div class="empty">
        <p>暂无体检报告，请先完成体检</p>
      </div>
    </div>

    <div class="bottom-ban"></div>
    <Footer></Footer>
  </div>
</template>

<script setup>
import Footer from "@/components/Footer.vue";
</script>

<style scoped>
.wrapper{
  width: 100%;
  height: 100%;
  background: #f7f7f7;
}
header{
  width: 100%;
  height: 15vw;
  background: #fff;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 4vw;
  box-sizing: border-box;
  position: fixed;
  top: 0;
  left: 0;
}
header i{
  font-size: 7vw;
}
header h2{
  font-size: 5vw;
  font-weight: 500;
}
.bottom-ban{
  height:14vw;
  width:100%;
}
.content{
  padding-top:16vw;
  width:92vw;
  margin:0 auto;
}
.empty{
  margin-top:30vw;
  text-align:center;
  font-size:4vw;
  color:#999;
}
</style>