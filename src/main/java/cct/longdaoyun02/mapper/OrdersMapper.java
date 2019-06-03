package cct.longdaoyun02.mapper;

import cct.longdaoyun02.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface OrdersMapper {
    List<Orders> findAllByStatus(Integer orderStatus1,Integer orderStatus2);
    List<Orders> findByOrders(@Param("createTimeBegin") Date createTimeBegin,
                              @Param("createTimeEnd") Date createTimeEnd,
                              @Param("orderNumber")String orderNumber,
                              @Param("buyerName")String buyerName,
                              @Param("orderStatus1")Integer orderStatus1,
                              @Param("orderStatus2")Integer orderStatus2,
                              @Param("orderStatus")Integer orderStatus);


}