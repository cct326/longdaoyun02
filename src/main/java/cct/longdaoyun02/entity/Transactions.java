package cct.longdaoyun02.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Transactions implements Serializable {
    private Integer id;

    private String itemNumber;

    private String itemName;

    private String companyName;

    private Date transactionsTime;

    private String offerIndate;
    //状态 1中标2未中标3全部报价4部分报价5撤标
    private Integer status;
    private String bargainIndate;
    private Date bidIndate;
    private String bidType;
    //竞价状态1待竞价2竞价中3评标中4未中标5已中标6已撤项
    private Integer bidStatus;
    private Date beginTime;
    private Orders orders;

}