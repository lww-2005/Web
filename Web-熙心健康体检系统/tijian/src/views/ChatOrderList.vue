<template>
<div class="wrapper">
  <header>
    <i class="fa fa-angle-left" @click="$router.back()"></i>
    <p>问诊订单</p>
    <div></div>
  </header>
  <div class="top-ban"></div>

  <section class="order-box">
    <div class="order-item" v-for="item in chatOrderArr" :key="item.id">
      <div class="doc-name">医生：{{item.docName}}</div>
      <div class="order-type">问诊类型：{{item.type}}</div>
      <div class="order-time">下单时间：{{item.time}}</div>
      <div class="order-status">状态：{{item.status}}</div>
    </div>
  </section>

  <div class="bottom-ban"></div>
  <Footer></Footer>
</div>
</template>

<script setup>
import Footer from "@/components/Footer.vue";
import { ref } from "vue";

const chatOrderArr = ref([
  {
    id:1,
    docName:"张内科",
    type:"图文问诊",
    time:"2026-06-10",
    status:"已完成"
  },
  {
    id:2,
    docName:"李骨科",
    type:"视频问诊",
    time:"2026-06-22",
    status:"待问诊"
  }
])
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
.order-box{
  width:90vw;
  margin:0 auto;
}
.order-item{
  background:#fff;
  border-radius:2vw;
  padding:5vw;
  margin-bottom:4vw;
}
.doc-name{
  font-size:4.4vw;
  font-weight:600;
  color:#02A6C9;
}
.order-type,.order-time,.order-status{
  font-size:3.4vw;
  color:#666;
  margin-top:2vw;
}
</style>