package com.neuedu.controller;
import com.neuedu.po.Orders;
import com.neuedu.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    // 校验用户是否已有未完成预约
    @PostMapping("/getOrdersByUserId")
    public int getOrdersByUserId(@RequestBody Orders orders) {
        return ordersService.getOrdersByUserId(orders.getUserId());
    }

    // 创建预约订单
    @PostMapping("/saveOrders")
    public int saveOrders(@RequestBody Orders orders) {
        return ordersService.saveOrders(orders);
    }

    // 【新增】查看我的全部预约订单
    @PostMapping("/listOrdersByUserId")
    public List<Orders> listOrdersByUserId(@RequestBody Orders orders) {
        return ordersService.listOrdersByUserId(orders);
    }

    // 【新增】取消预约订单
    @PostMapping("/removeOrders")
    public String removeOrders(@RequestBody Orders orders) {
        int res = ordersService.removeOrders(orders.getOrderId());
        if(res > 0){
            return "success";
        }else{
            return "fail";
        }
    }

    @PostMapping("/getOrdersById")
    public Orders getOrdersById(@RequestBody Orders orders) {
        return ordersService.getOrdersById(orders.getOrderId());
    }
}