package cct.longdaoyun02.service;

import cct.longdaoyun02.entity.Cargo;
import cct.longdaoyun02.mapper.CargoMapper;
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
public class CargoService {
    @Autowired
    private CargoMapper cargoMapper;

    public LayuiResponse myCargo(Integer status, Integer page, Integer size, Cargo cargo){
        PageHelper.startPage(page,size);
        PageInfo<Cargo> info=null;
        List<Cargo> list =null;
        //货单状态 1备货中2待收货3已签收4已拒收5已终止6已完成
        if (status==1){
            list = cargoMapper.findAllByStatus(1,6);
            info = new PageInfo<>(list);
        }
        if (status==2){
            list = cargoMapper.findAllByStatus(1,2);
            info = new PageInfo<>(list);
        }
        if (status==3){
            list = cargoMapper.findAllByStatus(3,4);
            info = new PageInfo<>(list);
        }
        if (status==4){
            list = cargoMapper.findAllByStatus(5,6);
            info = new PageInfo<>(list);
        }
        return LayuiResponse.data(info.getTotal(),list);
    }
    //根据条件查询，status代表对应的表格
    public LayuiResponse search(Integer status, Integer page, Integer size, String cargoTimes,Cargo cargo){
        Date cargoTimeBegin = null;
        Date cargoTimeEnd = null;
        PageHelper.startPage(page,size);
        PageInfo<Cargo> info = null;
        List<Cargo> list = null;
        String orderName=null;
        String buyerName=null;
        //转换时间段
        if (StringUtils.isNotEmpty(cargoTimes)){
            String[] times = cargoTimes.split("~");
            try {
                cargoTimeBegin = new SimpleDateFormat("yyyy-MM-dd").parse(times[0]);
                cargoTimeEnd = new SimpleDateFormat("yyyy-MM-dd").parse(times[1]);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        if (cargo.getOrders()!=null){
            orderName = cargo.getOrders().getOrderName();
            buyerName = cargo.getOrders().getBuyerName();
        }
        if (status==1){
            list = cargoMapper.findAllByCargo(cargoTimeBegin,cargoTimeEnd,orderName,
                    cargo.getCargoNumber(),buyerName,1,6,cargo.getCargoStatus());
            info =new PageInfo<>(list);
        }else if (status==2){
            list = cargoMapper.findAllByCargo(cargoTimeBegin,cargoTimeEnd,orderName,
                    cargo.getCargoNumber(),buyerName,1,2,cargo.getCargoStatus());
            info =new PageInfo<>(list);
        }else if (status==3){
            list = cargoMapper.findAllByCargo(cargoTimeBegin,cargoTimeEnd,orderName,
                    cargo.getCargoNumber(),buyerName,3,4,cargo.getCargoStatus());
            info =new PageInfo<>(list);
        }else if (status==4){
            list = cargoMapper.findAllByCargo(cargoTimeBegin,cargoTimeEnd,orderName,
                    cargo.getCargoNumber(),buyerName,5,6,cargo.getCargoStatus());
            info =new PageInfo<>(list);
        }else {
            return null;
        }
        return LayuiResponse.data(info.getTotal(),list);
    }




}
