package cct.longdaoyun02.controller;


import cct.longdaoyun02.model.LayuiResponse;
import cct.longdaoyun02.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionsController {
    @Autowired
    private TransactionsService transactionService;

    /*
    * 采购交易
    * */
    @PostMapping("/mytransaction")
    public LayuiResponse myTransaction(Integer page, Integer limit, Integer flag, @RequestParam(defaultValue = "") String keyword){
        return transactionService.myTransaction(page,limit,flag,keyword);
    }
}
