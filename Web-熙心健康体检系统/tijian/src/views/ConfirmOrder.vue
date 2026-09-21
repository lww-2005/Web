<template>
    <div class="wrapper">
          <header>
              <i class="fa fa-angle-left" onclick="history.go(-1)"></i>
              <p>确认您的订单</p>
              <div></div>
          </header>
          <div class="top-ban"></div>
  
          <section>
              <div class="title">
                  <p>体检人信息</p>
              </div>
              <table>
              <tbody>
                  <tr>
                      <td>姓名:</td>
                      <td>{{state.users.realName}}</td>
                  </tr>
                  <tr>
                      <td>证件号码:</td>
                      <td>{{state.users.identityCard}}</td>
                  </tr>
                  <tr>
                      <td>出生日期:</td>
                      <td>{{state.users.birthday}}</td>
                  </tr>
                  <tr>
                      <td>手机号码:</td>
                      <td>{{state.users.userId}}</td>
                  </tr>
              </tbody>
              </table>
              <div class="title">
                  <p>体检日期</p>
              </div>
              <table>
              <tbody>
                  <tr>
                      <td>{{state.selectDay.split("-")[0]}}年{{state.selectDay.split("-")[1]}}月{{state.selectDay.split("-")[2]}}日</td>
                  </tr>
              </tbody>
              </table>
              <div class="title">
                  <p>体检机构</p>
              </div>
              <table>
                  <tbody>
                  <tr>
                      <td colspan="2">{{state.hospital.name}}</td>
                  </tr>
                  <tr>
                      <td>营业时间:</td>
                      <td>{{state.hospital.businessHours}}</td>
                  </tr>
                  <tr>
                      <td>采血截止:</td>
                      <td>{{state.hospital.deadline}}</td>
                  </tr>
                  <tr>
                      <td>机构电话:</td>
                      <td>{{state.hospital.telephone}}</td>
                  </tr>
                  <tr>
                      <td>机构地址:</td>
                      <td>{{state.hospital.address}}</td>
                  </tr>
              </tbody>
              </table>
              <div class="title">
                  <p>套餐类型</p>
              </div>
              <table>
              <tbody>
                  <tr>
                      <td>{{state.setmeal.name}}</td>
                  </tr>
              </tbody>
              </table>
          </section>
          
          <div class="bottom-btn">
              <div class="first">实付款: <span>￥{{state.users.userType==2?0:state.setmeal.price}}</span></div>
              <div class="last" @click="toSuccess" v-if="state.flag==1">确认支付</div>
          </div>
  
          <div class="bottom-ban"></div>
          <Footer></Footer>
      </div>
  </template>
  
  <script setup>
  import Footer from "@/components/Footer.vue";
  import { reactive} from "vue";
  import { useRoute, useRouter } from "vue-router";
  import {inject} from 'vue';
  const axios = inject('axios');
  import { getSessionStorage } from "../common.js";
  
      const router = useRouter();
      const route = useRoute();
  
      const state = reactive({
        hpId: route.query.hpId,
        smId: route.query.smId,
        selectDay: route.query.selectDay,
        flag: route.query.flag,
        users: getSessionStorage('users'),
        hospital: {},
        setmeal: {}
      });
  
      init();
      function init(){
        axios
          .post("hospital/getHospitalById", {
            hpId: state.hpId
          })
          .then((response) => {
            state.hospital = response.data;
          })
          .catch((error) => {
            console.error(error);
          });
  
        axios
          .post("setmeal/getSetmealById", {
            smId: state.smId
          })
          .then((response) => {
            state.setmeal = response.data;
          })
          .catch((error) => {
            console.error(error);
          });  
      }
  
      function toSuccess(){
        axios
          .post("orders/saveOrders", {
            orderDate: state.selectDay,
            userId: state.users.userId,
            hpId: state.hpId,
            smId: state.smId
          })
          .then((response) => {
            if(response.data==1){
              router.push('/appointmentSuccess');
            }else{
              alert('生成订单失败！');
            }
          })
          .catch((error) => {
            console.error(error);
          });  
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
      height: 26.2vw;
  }
  
  /*********************** section ***********************/
  section{
      width: 86vw;
      margin: 0 auto;
  }
  section .title{
      width: 100%;
      height: 12vw;
      border-bottom: solid 1px #EEE;
  
      display: flex;
      align-items: center;
  }
  section .title p{
      height: 3.4vw;
      line-height: 3.4vw;
      font-size: 4.2vw;
      font-weight: 600;
      box-sizing: border-box;
      padding-left: 3vw;
      border-left: solid 2px #127A90;
  }
  section table{
      font-size: 3.6vw;
      color: #555;
      margin-top: 2vw;
  }
  section table tr{
      line-height: 8vw;
  }
  section table tr td:first-child{
      width: 22%;
  }
  
  /*********************** bottom-btn ***********************/
  .bottom-btn{
      width: 100%;
      height: 12vw;
      background-color: #FFF;
  
      position: fixed;
      left: 0;
      bottom: 14.2vw;
  
      display: flex;
  }
  .bottom-btn .first{
      flex: 2;
      line-height: 12vw;
      font-size: 4.6vw;
      box-sizing: border-box;
      padding-left: 6vw;
  }
  .bottom-btn .first span{
      color: #F77B2D;
  }
  .bottom-btn .last{
      flex: 1;
      background-color: #117C94;
      line-height: 12vw;
      text-align: center;
      font-size: 5vw;
      color: #FFF;
  
      user-select: none;
      cursor: pointer;
  }
  </style>