package cct.longdaoyun02.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Cargo implements Serializable {
    private Integer id;

    private String cargoNumber;

    private String cargoAmount;

    private Integer cargoStatus;

    private Date cargoTime;

    private Date deliveryDate;

    private Orders orders;

}