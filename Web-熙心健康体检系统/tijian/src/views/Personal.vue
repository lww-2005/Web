<template>
    <div class="wrapper">
          <header>
              <i class="fa fa-angle-left" onclick="history.go(-1)"></i>
              <p>个人中心</p>
              <div></div>
          </header>
          <div class="top-ban"></div>
  
          <section>
              <div class="info">
                  <div class="content">
                      <img src="../assets/user.png">
                      <div>
                        <!-- 加?. 空值兜底，不会报错阻断页面 -->
                          <p>{{users?.realName || "游客"}}</p>
                          <p>账号: {{users?.userId || "未登录"}}</p>
                      </div>
                  </div>
              </div>
              <ul>
                  <!-- 我的预约 -->
                  <li>
                      <div class="left">
                          <i class="fa fa-user-plus"></i>
                          <p>我的预约</p>
                      </div>
                      <div class="right" @click="toAppointmentList">
                          <i class="fa fa-angle-right"></i>
                      </div>
                  </li>
                  <!-- 我的服务 -->
                  <li>
                      <div class="left">
                          <i class="fa fa-volume-control-phone"></i>
                          <p>我的服务</p>
                      </div>
                      <div class="right" @click="toService">
                          <i class="fa fa-angle-right"></i>
                      </div>
                  </li>
                  <!-- 我的医生 -->
                  <li>
                      <div class="left">
                          <i class="fa fa-bed"></i>
                          <p>我的医生</p>
                      </div>
                      <div class="right" @click="toDoctor">
                          <i class="fa fa-angle-right"></i>
                      </div>
                  </li>
                  <!-- 问诊订单 -->
                  <li>
                      <div class="left">
                          <i class="fa fa-sticky-note"></i>
                          <p>问诊订单</p>
                      </div>
                      <div class="right" @click="toChatOrder">
                          <i class="fa fa-angle-right"></i>
                      </div>
                  </li>
                  <!-- 退出登录 -->
                  <li>
                      <div class="left">
                          <i class="fa fa-sign-out"></i>
                          <p>退出登录</p>
                      </div>
                      <div class="right" @click="out">
                          <i class="fa fa-angle-right"></i>
                      </div>
                  </li>
              </ul>
          </section>
          
          <div class="bottom-ban"></div>
          <Footer></Footer>
      </div>
  </template>
  
  <script setup>
  import Footer from "@/components/Footer.vue";
  import { reactive } from "vue";
  import { useRouter } from "vue-router";
  import {inject} from 'vue';
  import { getSessionStorage, removeSessionStorage } from "../common.js";
  
  const axios = inject('axios');
  const router = useRouter();
  // 兜底：取不到用户数据给空对象，杜绝渲染报错
  const userData = getSessionStorage('users')
  const users = reactive(userData ? userData : { realName:"游客",userId:"" });

  // 我的预约
  function toAppointmentList(){
    router.push('/appointmentList');
  }
  // 我的服务
  function toService(){
    router.push('/serviceList');
  }
  // 我的医生
  function toDoctor(){
    router.push('/doctorList');
  }
  // 问诊订单
  function toChatOrder(){
    router.push('/chatOrderList');
  }
  // 退出登录
  function out(){
    removeSessionStorage('users');
    router.push('/login');
  }
  </script>
  
  <style scoped>
  /*********************** 总容器 ***********************/
  .wrapper{
      width: 100%;
      height: 100%;
      background-color: #F9F9F9;
  }
  
  /*********************** header ***********************/
  header{
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
  header .fa{
      font-size: 8vw;
  }
  
  /*********************** common样式 ***********************/
  .top-ban{
      width: 100%;
      height: 15.7vw;
  }
  .bottom-ban{
      width: 100%;
      height: 14.2vw;
  }
  
  /*********************** section ***********************/
  section{
      width: 100%;
  }
  section .info{
      width: 100%;
      height: 30vw;
      background-image: linear-gradient(135deg,#7DB35D,#02A6C9,#02A6C9);
      display: flex;
      align-items: center;
  }
  section .info .content{
      width: 90vw;
      margin: 0 auto;
      display: flex;
  }
  section .info .content img{
      width: 14vw;
      height: 14vw;
      border-radius: 7vw;
  }
  section .info .content div{
      height: 14vw;
      margin-left: 3vw;
      color: #FFF;
  }
  section .info .content div p:first-child{
      font-size: 4.8vw;
  }
  section .info .content div p:last-child{
      font-size: 3.2vw;
      margin-top: 2.6vw;
  }
  
  section ul{
      width: 86vw;
      margin: 0 auto;
  }
  section ul li{
      width: 100%;
      height: 14vw;
      border-bottom: solid 1px #EEE;
      color: #555;
      font-size: 4.2vw;
      font-weight: 600;
      display: flex;
      justify-content: space-between;
      align-items: center;
  }
  section ul li .left{
      display: flex;
      align-items: center;
  }
  section ul li .left p{
      margin-left: 3vw;
  }
  section ul li .right{
      user-select: none;
      cursor: pointer;
  }
  section ul li .right i{
      font-size: 6vw;
  }
  </style>