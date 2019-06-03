package cct.longdaoyun02.controller;

import cct.longdaoyun02.entity.Cargo;
import cct.longdaoyun02.entity.Orders;
import cct.longdaoyun02.model.LayuiResponse;
import cct.longdaoyun02.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargo")
public class CargoController {
    @Autowired
    private CargoService cargoService;

    @PostMapping("/mycargo/{status}")
    public LayuiResponse myCargo(@PathVariable("status") Integer status, Integer page, Integer limit, Cargo cargo) {
        return cargoService.myCargo(status,page,limit,cargo);
    }

    @PostMapping("/search/{status}")
    public LayuiResponse search(@PathVariable("status") Integer status, Integer page, Integer limit, Cargo cargo,
                                String orderName,String buyerName,
                                String cargoTimes) {
        Orders orders=new Orders();
        orders.setBuyerName(buyerName);
        orders.setOrderName(orderName);
        cargo.setOrders(orders);
        return cargoService.search(status,page,limit,cargoTimes,cargo);
    }
}
