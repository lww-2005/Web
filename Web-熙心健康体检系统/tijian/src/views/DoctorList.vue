<template>
<div class="wrapper">
  <!-- 顶部导航栏 -->
  <header>
    <i class="fa fa-angle-left" @click="$router.back()"></i>
    <p>我的医生</p>
    <div></div>
  </header>
  <div class="top-ban"></div>

  <section class="doctor-list">
    <!-- 医生单项 -->
    <div class="doctor-item" v-for="item in doctorArr" :key="item.id" @click="showDetail(item)">
      <img :src="item.avatar" alt="医生头像" />
      <div class="doctor-info">
        <p class="name">{{ item.name }}</p>
        <p class="dep">科室：{{ item.department }}</p>
        <p class="title">职称：{{ item.title }}</p>
      </div>
      <div class="consult-btn">在线问诊</div>
    </div>
  </section>

  <!-- 医生详情弹窗 -->
  <div class="mask" v-if="showMask" @click="showMask = false">
    <div class="detail-box" @click.stop>
      <h3>{{ currDoctor.name }}</h3>
      <p>科室：{{ currDoctor.department }}</p>
      <p>职称：{{ currDoctor.title }}</p>
      <p>擅长：{{ currDoctor.skill }}</p>
      <p>简介：{{ currDoctor.intro }}</p>
      <div class="close-btn" @click="showMask = false">关闭</div>
    </div>
  </div>

  <div class="bottom-ban"></div>
  <Footer></Footer>
</div>
</template>

<script setup>
import Footer from "@/components/Footer.vue";
import { ref } from "vue";

// 医生模拟数据
const doctorArr = ref([
  {
    id: 1,
    avatar: "../assets/user.png",
    name: "张大夫",
    department: "内科",
    title: "主任医师",
    skill: "高血压、糖尿病、心脑血管疾病诊疗",
    intro: "从业20年，三甲医院内科主任，擅长中老年慢性病调理。"
  },
  {
    id: 2,
    avatar: "../assets/user.png",
    name: "李医生",
    department: "骨科",
    title: "副主任医师",
    skill: "腰椎间盘突出、关节损伤、康复理疗",
    intro: "擅长骨科微创手术，长期负责体检人群骨骼健康评估。"
  },
  {
    id: 3,
    avatar: "../assets/user.png",
    name: "王医师",
    department: "消化科",
    title: "主治医师",
    skill: "胃炎、肠胃溃疡、幽门螺旋杆菌诊疗",
    intro: "专注消化道疾病，常年负责体检肠胃专项解读。"
  }
]);

// 弹窗控制
const showMask = ref(false);
const currDoctor = ref({});

// 打开详情弹窗
function showDetail(item) {
  currDoctor.value = item;
  showMask.value = true;
}
</script>

<style scoped>
.wrapper {
  width: 100%;
  height: 100%;
  background-color: #F9F9F9;
}

/* 头部通用 */
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

/* 医生列表 */
.doctor-list {
  width: 90vw;
  margin: 0 auto;
}
.doctor-item {
  width: 100%;
  background: #fff;
  border-radius: 2vw;
  padding: 4vw;
  margin-bottom: 4vw;
  display: flex;
  align-items: center;
  gap: 3vw;
}
.doctor-item img {
  width: 16vw;
  height: 16vw;
  border-radius: 50%;
}
.doctor-info {
  flex: 1;
}
.doctor-info .name {
  font-size: 4.4vw;
  font-weight: 600;
  color: #333;
}
.doctor-info .dep, .doctor-info .title {
  font-size: 3.2vw;
  color: #666;
  margin-top: 1vw;
}
.consult-btn {
  padding: 2vw 3vw;
  background: #02A6C9;
  color: #fff;
  border-radius: 2vw;
  font-size: 3.2vw;
  white-space: nowrap;
}

/* 弹窗遮罩 */
.mask {
  position: fixed;
  left: 0;
  top: 0;
  width: 100vw;
  height: 100vh;
  background: rgba(0,0,0,0.6);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 999;
}
.detail-box {
  width: 80vw;
  background: #fff;
  border-radius: 3vw;
  padding: 6vw;
}
.detail-box h3 {
  font-size: 5vw;
  text-align: center;
  margin-bottom: 4vw;
  color: #02A6C9;
}
.detail-box p {
  font-size: 3.6vw;
  line-height: 1.8;
  color: #444;
  margin: 2vw 0;
}
.close-btn {
  width: 100%;
  height: 10vw;
  line-height: 10vw;
  text-align: center;
  background: #02A6C9;
  color: #fff;
  border-radius: 2vw;
  margin-top: 4vw;
  font-size: 4vw;
}
</style>