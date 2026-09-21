package com.neuedu.mapper;
import com.neuedu.dto.CalendarResponseDto;
import com.neuedu.dto.OrdersMapperDto;
import com.neuedu.po.Orders;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface OrdersMapper {
    // 判断用户是否存在未归档订单
    @Select("select count(*) from orders where state=1 and userId=#{userId}")
    int getOrdersByUserId(String userId);

    // 查询30天预约人数（日历用）
    List<CalendarResponseDto> listOrdersAppointmentNumber(List<OrdersMapperDto> list);

    // 新增预约订单
    @Insert("insert into orders values(null,#{orderDate},#{userId},#{hpId},#{smId},1)")
    int saveOrders(Orders orders);

    // 根据用户ID查询我的预约订单（关联医院、套餐）
    List<Orders> listOrdersByUserId(Orders orders);

    // 根据订单ID查询单条订单
    @Select("select * from orders where orderId=#{orderId}")
    Orders getOrdersById(Integer orderId);

    // 删除订单（取消预约，物理删除；可改为update软删除）
    @Delete("delete from orders where orderId=#{orderId} and state=1")
    int removeOrders(Integer orderId);
}