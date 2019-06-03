package cct.longdaoyun02.controller;

import cct.longdaoyun02.entity.Orders;
import cct.longdaoyun02.model.LayuiResponse;
import cct.longdaoyun02.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/myorder/{orderStatus}")
    public LayuiResponse myOrder(@PathVariable("orderStatus")Integer orderStatus, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit){
        return ordersService.myOrder(orderStatus,page,limit);

    }

    @PostMapping("/search/{status}")
    public LayuiResponse search(@PathVariable("status")Integer status, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit,
                                String createTimes,Orders orders){
        return ordersService.search(status,page,limit,createTimes,orders);

    }




}
