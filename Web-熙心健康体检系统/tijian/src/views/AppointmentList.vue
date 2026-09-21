<template>
  <div class="wrapper">
    <!-- 头部导航 -->
    <header>
      <i class="fa fa-angle-left" @click="$router.back()"></i>
      <p>我的预约订单</p>
      <div></div>
    </header>
    <div class="top-ban"></div>

    <!-- 订单列表 -->
    <section v-if="orderList.length > 0">
      <ul class="order-ul">
        <li v-for="item in orderList" :key="item.orderId">
          <div class="order-title">
            <span>预约单号：{{ item.orderId }}</span>
            <span class="state-tag">可取消</span>
          </div>
          <div class="order-info">
            <p>体检医院：{{ item.hospital.name }}</p>
            <p>体检套餐：{{ item.setmeal.name }}</p>
            <p>预约日期：{{ item.orderDate }}</p>
            <p>套餐价格：¥{{ item.setmeal.price }}</p>
          </div>
          <div class="cancel-box">
            <div class="cancel-btn" @click="cancelOrder(item.orderId)">取消预约</div>
          </div>
        </li>
      </ul>
    </section>
    <!-- 无订单提示 -->
    <section v-else class="empty-tip">
      <p>暂无体检预约订单</p>
      <div class="go-yuyue" @click="$router.push('/appointment')">去预约体检</div>
    </section>

    <div class="bottom-ban"></div>
    <Footer></Footer>
  </div>
</template>

<script setup>
import Footer from "@/components/Footer.vue";
import { ref, onMounted, inject } from "vue";
import { useRouter } from "vue-router";
import { getSessionStorage } from "@/common.js";

const router = useRouter();
const axios = inject("axios");
const orderList = ref([]);
const user = getSessionStorage("users");

// 页面加载查询我的订单
onMounted(() => {
  loadOrderList();
});

// 查询订单接口
function loadOrderList() {
  axios.post("/orders/listOrdersByUserId", {
    userId: user.userId
  }).then(res => {
    orderList.value = res.data;
  }).catch(err => {
    console.error("加载订单失败", err);
  })
}

// 取消订单
function cancelOrder(orderId) {
  if (!confirm("确定要取消本次体检预约吗？取消后名额会释放！")) {
    return;
  }
  axios.post("/orders/removeOrders", {
    orderId: orderId
  }).then(res => {
    if (res.data === "success") {
      alert("取消预约成功");
      loadOrderList(); // 刷新列表
    } else {
      alert("取消失败，订单已出报告无法取消");
    }
  }).catch(err => {
    console.error(err);
  })
}
</script>

<style scoped>
.wrapper {
  width: 100%;
  height: 100%;
  background-color: #f9f9f9;
}
header {
  width: 100%;
  height: 15.7vw;
  background: #fff;
  position: fixed;
  top: 0;
  left: 0;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 3.6vw;
  box-sizing: border-box;
}
header .fa {
  font-size: 8vw;
}
.top-ban {
  height: 15.7vw;
  width: 100%;
}
.bottom-ban {
  height: 14.2vw;
  width: 100%;
}
.order-ul {
  width: 92.8vw;
  margin: 0 auto;
}
.order-ul li {
  background: #fff;
  border-radius: 1vw;
  padding: 4vw;
  margin-bottom: 4vw;
}
.order-title {
  display: flex;
  justify-content: space-between;
  font-size: 4vw;
  padding-bottom: 2vw;
  border-bottom: 1px solid #eee;
}
.state-tag {
  color: #02a6c9;
}
.order-info {
  margin-top: 3vw;
  font-size: 3.6vw;
  color: #555;
}
.order-info p {
  line-height: 8vw;
}
.cancel-box {
  margin-top: 4vw;
  text-align: right;
}
.cancel-btn {
  width: 24vw;
  height: 8vw;
  line-height: 8vw;
  border: 1px solid #f56c6c;
  color: #f56c6c;
  border-radius: 1vw;
  text-align: center;
  font-size: 3.6vw;
}
.empty-tip {
  margin-top: 30vw;
  text-align: center;
  font-size: 4.5vw;
  color: #999;
}
.go-yuyue {
  width: 60vw;
  height: 12vw;
  line-height: 12vw;
  background: #02a6c9;
  color: #fff;
  border-radius: 2vw;
  margin: 10vw auto 0;
  font-size: 4vw;
}
</style>