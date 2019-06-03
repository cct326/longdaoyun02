package cct.longdaoyun02.model;

import java.util.HashMap;
import java.util.List;

public class LayuiResponse extends HashMap<String ,Object> {
    public static LayuiResponse data(Long count, List<?> data){
        LayuiResponse res=new LayuiResponse();
        res.put("code",0);
        res.put("msg","");
        res.put("count",count);
        res.put("data",data);
        return res;
    }
}
