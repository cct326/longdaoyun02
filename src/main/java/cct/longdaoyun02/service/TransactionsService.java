package cct.longdaoyun02.service;


import cct.longdaoyun02.entity.Transactions;
import cct.longdaoyun02.mapper.TransactionsMapper;
import cct.longdaoyun02.model.LayuiResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {
    @Autowired
    private TransactionsMapper transactionMapper;
    //采购交易的显示和查询
    public LayuiResponse myTransaction(Integer page, Integer size, Integer flag, String keyword){
        PageHelper.startPage(page,size);
        PageInfo<Transactions> info=null;
        List<Transactions> list = null;
        if (flag==null){
            list = transactionMapper.findByItemName(keyword);
            info=new PageInfo<>(list);
            return LayuiResponse.data(info.getTotal(),list);
        }
        if (flag==1){
            //1按照项目名称模糊查询
            list = transactionMapper.findByItemName(keyword);
            info=new PageInfo<>(list);
            return LayuiResponse.data(info.getTotal(),list);
        }
        if (flag==2){
            //2按照发布企业查询
            list = transactionMapper.findByCompanyName(keyword);
            info=new PageInfo<>(list);
            return LayuiResponse.data(info.getTotal(),list);
        }
        if (flag==3){
            //3按照项目编码查询
            list = transactionMapper.findByItemNumber(keyword);
            info=new PageInfo<>(list);
            return LayuiResponse.data(info.getTotal(),list);
        }
        return null;
    }

    //竞价交易的显示
    public LayuiResponse myBidding(Integer status,Integer page, Integer size){
       PageHelper.startPage(page,size);
       PageInfo<Transactions> info = null;
       List<Transactions> list = null;
        //竞价状态1待竞价2竞价中3评标中4未中标5已中标6已撤项
        if (status==1){
            list = transactionMapper.findByStatus(1, 6);
            info = new PageInfo<>(list);
        }else if (status==2){
            list = transactionMapper.findByStatus(1, 1);
            info = new PageInfo<>(list);
        }else if (status==3){
            list = transactionMapper.findByStatus(2, 2);
            info = new PageInfo<>(list);
        }else if (status==4){
            list = transactionMapper.findByStatus(3, 3);
            info = new PageInfo<>(list);
        }else if (status==5){
            list = transactionMapper.findByStatus(4, 5);
            info = new PageInfo<>(list);
        }else if (status==6){
            list = transactionMapper.findByStatus(6, 6);
            info = new PageInfo<>(list);
        }else {
            return null;
        }
        return LayuiResponse.data(info.getTotal(),list);
    }

    //竞价交易的搜索
    public LayuiResponse search(Integer status,Integer page,
                                Integer size,String keyword,Integer bidStatus){
        PageHelper.startPage(page,size);
        PageInfo<Transactions> info = null;
        List<Transactions> list = null;
        //竞价状态1待竞价2竞价中3评标中4未中标5已中标6已撤项
        if (status==1){
            list = transactionMapper.findByTrans(keyword,bidStatus,1,6);
            info = new PageInfo<>(list);
        }else if(status==2){
            list = transactionMapper.findByTrans(keyword,bidStatus,1,1);
            info = new PageInfo<>(list);
        }else if(status==3){
            list = transactionMapper.findByTrans(keyword,bidStatus,2,2);
            info = new PageInfo<>(list);
        }else if(status==4){
            list = transactionMapper.findByTrans(keyword,bidStatus,3,3);
            info = new PageInfo<>(list);
        }else if(status==5){
            list = transactionMapper.findByTrans(keyword,bidStatus,4,5);
            info = new PageInfo<>(list);
        }else if(status==6){
            list = transactionMapper.findByTrans(keyword,bidStatus,6,6);
            info = new PageInfo<>(list);
        }else {
            return null;
        }
        return LayuiResponse.data(info.getTotal(),list);
    }
}
