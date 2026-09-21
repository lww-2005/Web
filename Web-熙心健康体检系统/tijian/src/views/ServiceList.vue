<template>
<div class="wrapper">
  <!-- 顶部导航 -->
  <header>
    <i class="fa fa-angle-left" @click="$router.back()"></i>
    <p>我的服务</p>
    <div></div>
  </header>
  <div class="top-ban"></div>

  <section class="service-box">
    <div class="service-item" v-for="item in serviceArr" :key="item.id">
      <div class="service-title">{{ item.name }}</div>
      <div class="service-desc">{{ item.desc }}</div>
      <div class="service-time">开通时间：{{ item.time }}</div>
    </div>
  </section>

  <div class="bottom-ban"></div>
  <Footer></Footer>
</div>
</template>

<script setup>
import Footer from "@/components/Footer.vue";
import { ref } from "vue";

// 模拟服务数据
const serviceArr = ref([
  {
    id: 1,
    name: "基础体检套餐",
    desc: "常规血常规、尿常规、胸片、腹部彩超基础体检服务",
    time: "2026-05-10"
  },
  {
    id: 2,
    name: "医生在线问诊年卡",
    desc: "全年不限次数图文问诊，优先匹配三甲医师",
    time: "2026-05-12"
  },
  {
    id: 3,
    name: "慢病健康管理",
    desc: "高血压/糖尿病专属健康跟踪、饮食指导服务",
    time: "2026-06-01"
  }
]);
</script>

<style scoped>
.wrapper {
  width: 100%;
  height: 100%;
  background-color: #F9F9F9;
}

header {
  width: 100%;
  height: 15.7vw;
  background-color: #FFF;
  position: fixed;
  left: 0;
  top: 0;
  display: flex;
  align-items: center;
  justify-content: space-between;
  box-sizing: border-box;
  padding: 0 3.6vw;
}
header .fa {
  font-size: 8vw;
  cursor: pointer;
}
header p {
  font-size: 4.6vw;
  font-weight: 500;
}

.top-ban {
  width: 100%;
  height: 15.7vw;
}
.bottom-ban {
  width: 100%;
  height: 14.2vw;
}

.service-box {
  width: 90vw;
  margin: 0 auto;
}
.service-item {
  background: #fff;
  border-radius: 2vw;
  padding: 5vw;
  margin-bottom: 4vw;
}
.service-title {
  font-size: 4.4vw;
  font-weight: 600;
  color: #02A6C9;
}
.service-desc {
  font-size: 3.4vw;
  color: #666;
  margin: 2vw 0;
  line-height: 1.6;
}
.service-time {
  font-size: 3vw;
  color: #999;
}
</style>