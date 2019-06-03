package cct.longdaoyun02.controller;

import cct.longdaoyun02.model.LayuiResponse;
import cct.longdaoyun02.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bidding")
public class BiddingController {
    @Autowired
    private TransactionsService transactionsService;

   @PostMapping("/mybidding/{status}")
    public LayuiResponse myBidding(@PathVariable("status") Integer status,Integer page,Integer limit){
       return transactionsService.myBidding(status,page,limit);
   }

    @PostMapping("/search/{status}")
    public LayuiResponse search(@PathVariable("status") Integer status,Integer page,Integer limit,
                                @RequestParam(defaultValue = "")String keyword,Integer bidStatus){
        return transactionsService.search(status,page,limit,keyword,bidStatus);
    }
}
