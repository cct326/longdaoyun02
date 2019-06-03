package cct.longdaoyun02.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {
    private Integer id;
    private String buyerName;
    private String orderNumber;
    private Integer orderStatus;
    private Date createTime;
    private String orderName;
    private String orderAmount;

}
