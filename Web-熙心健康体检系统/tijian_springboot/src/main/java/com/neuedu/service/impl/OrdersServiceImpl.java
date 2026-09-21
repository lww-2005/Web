package com.neuedu.service.impl;
import com.neuedu.mapper.OrdersMapper;
import com.neuedu.po.Orders;
import com.neuedu.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public int getOrdersByUserId(String userId) {
        return ordersMapper.getOrdersByUserId(userId);
    }

    @Override
    public int saveOrders(Orders orders) {
        return ordersMapper.saveOrders(orders);
    }

    // 查询当前用户所有预约订单
    @Override
    public List<Orders> listOrdersByUserId(Orders orders) {
        return ordersMapper.listOrdersByUserId(orders);
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        return ordersMapper.getOrdersById(orderId);
    }

    // 取消订单：先判断订单状态，已出报告不可取消
    @Override
    public int removeOrders(Integer orderId) {
        Orders order = ordersMapper.getOrdersById(orderId);
        if(order == null || order.getState() != 1){
            // 订单不存在 或 已完成出报告，禁止取消
            return 0;
        }
        return ordersMapper.removeOrders(orderId);
    }
}