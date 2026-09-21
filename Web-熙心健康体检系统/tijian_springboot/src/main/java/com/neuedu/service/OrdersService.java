package com.neuedu.service;
import com.neuedu.po.Orders;
import java.util.List;
public interface OrdersService {
    // 获取用户未完成订单数量
    int getOrdersByUserId(String userId);
    // 创建预约订单
    int saveOrders(Orders orders);
    // 查询我的全部预约订单
    List<Orders> listOrdersByUserId(Orders orders);
    // 根据订单ID查询订单
    Orders getOrdersById(Integer orderId);
    // 取消订单（仅state=1可删除）
    int removeOrders(Integer orderId);
}