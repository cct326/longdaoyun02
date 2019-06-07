package cct.longdaoyun02.model;

import lombok.Data;

import java.util.List;
@Data
public class Result {
    private Integer code;
    private String msg;
    private Long count;
    private List<?> data;

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;

    }
}
