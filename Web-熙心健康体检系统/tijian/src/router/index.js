import { createRouter, createWebHashHistory } from 'vue-router'

// 所有页面懒加载引入
const Index = () => import('../views/Index.vue')
const Login = () => import('../views/Login.vue')
const Register = () => import('../views/Register.vue')
const Appointment = () => import('../views/Appointment.vue')
const AppointmentList = () => import('../views/AppointmentList.vue')
const AppointmentSuccess = () => import('../views/AppointmentSuccess.vue')
const ChatOrderList = () => import('../views/ChatOrderList.vue')
const ConfirmOrder = () => import('../views/ConfirmOrder.vue')
const DoctorList = () => import('../views/DoctorList.vue')
const HomeView = () => import('../views/HomeView.vue')
const Hospital = () => import('../views/Hospital.vue')
const Personal = () => import('../views/Personal.vue')
const SelectDate = () => import('../views/SelectDate.vue')
const ServiceList = () => import('../views/ServiceList.vue')
const SetMeal = () => import('../views/Setmeal.vue')
const AboutView = () => import('../views/AboutView.vue')
// 新增体检报告页面
const Report = () => import('../views/Report.vue')

// 路由列表
const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  },
  {
    path: '/index',
    name: 'Index',
    component: Index
  },
  {
    path: '/appointment',
    name: 'Appointment',
    component: Appointment
  },
  {
    path: '/appointmentList',
    name: 'AppointmentList',
    component: AppointmentList
  },
  {
    path: '/appointmentSuccess',
    name: 'AppointmentSuccess',
    component: AppointmentSuccess
  },
  {
    path: '/chatOrderList',
    name: 'ChatOrderList',
    component: ChatOrderList
  },
  {
    path: '/confirmOrder',
    name: 'ConfirmOrder',
    component: ConfirmOrder
  },
  {
    path: '/doctorList',
    name: 'DoctorList',
    component: DoctorList
  },
  {
    path: '/homeView',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/hospital',
    name: 'Hospital',
    component: Hospital
  },
  {
    path: '/personal',
    name: 'Personal',
    component: Personal
  },
  {
    path: '/selectDate',
    name: 'SelectDate',
    component: SelectDate
  },
  {
    path: '/serviceList',
    name: 'ServiceList',
    component: ServiceList
  },
  {
    path: '/setMeal',
    name: 'SetMeal',
    component: SetMeal
  },
  {
    path: '/aboutView',
    name: 'AboutView',
    component: AboutView
  },
  // 新增体检报告路由
  {
    path: '/report',
    name: 'Report',
    component: Report
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router