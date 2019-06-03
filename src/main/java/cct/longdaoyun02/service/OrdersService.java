package cct.longdaoyun02.service;

import cct.longdaoyun02.entity.Orders;
import cct.longdaoyun02.mapper.OrdersMapper;
import cct.longdaoyun02.model.LayuiResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;

    //查询全部订单
    public LayuiResponse myOrder(Integer status,Integer page, Integer size){
        PageHelper.startPage(page,size);
        PageInfo<Orders> info = null;
        List<Orders> list = null;
       // 订单状态 0代表查所有 1待确认2执行中3已终止4已完成
        if (status==0){
            list = ordersMapper.findAllByStatus(1,4);
            info=new PageInfo<>(list);
        }else if (status==1){
            list =ordersMapper.findAllByStatus(status,status);
            info=new PageInfo<>(list);
        }else if (status==2){
            list =ordersMapper.findAllByStatus(status,status);
            info=new PageInfo<>(list);
        } else if (status==3){
            list =ordersMapper.findAllByStatus(status,status+1);
            info=new PageInfo<>(list);
        }else {
            return null;
        }
       return  LayuiResponse.data(info.getTotal(),list);

    }
    //根据条件查询
    public LayuiResponse search(Integer status,Integer page,Integer size,String createTimes,Orders orders){
        Date createTimeBegin = null;
        Date createTimeEnd = null;
        PageHelper.startPage(page,size);
        PageInfo<Orders> info = null;
        List<Orders> list = null;
        //转换时间段
        if (StringUtils.isNotEmpty(createTimes)) {
            String[] times = createTimes.split("~");
            try {
                createTimeBegin = new SimpleDateFormat("yyyy-MM-dd").parse(times[0]);
                createTimeEnd = new SimpleDateFormat("yyyy-MM-dd").parse(times[1]);
            } catch (ParseException e) {
                e.printStackTrace();
                return LayuiResponse.data(0L, null);
            }
        }
        //1234分别代表第几个表格
        if (status==1){
            list = ordersMapper.findByOrders(createTimeBegin, createTimeEnd,orders.getOrderNumber(),orders.getBuyerName(),1,4,orders.getOrderStatus());
            info = new PageInfo<>(list);
        }else if(status==2){
            list = ordersMapper.findByOrders(createTimeBegin,createTimeEnd,orders.getOrderNumber(),orders.getBuyerName(),1,1,orders.getOrderStatus());
            info = new PageInfo<>(list);
        }else if (status==3){
            list = ordersMapper.findByOrders(createTimeBegin,createTimeEnd,orders.getOrderNumber(),orders.getBuyerName(),2,2,orders.getOrderStatus());
            info = new PageInfo<>(list);
        }else if (status==4){
            list = ordersMapper.findByOrders(createTimeBegin,createTimeEnd,orders.getOrderNumber(),orders.getBuyerName(),3,4,orders.getOrderStatus());
            info = new PageInfo<>(list);
        }else {

            return null;
        }

        return LayuiResponse.data(info.getTotal(),list);

        }


}
