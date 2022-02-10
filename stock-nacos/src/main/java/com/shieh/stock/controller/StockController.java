package com.shieh.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {



    @RequestMapping("/reduce")
    public String reduceStock(){
        System.out.println("扣减库存");
        return "reduce success";
    }
}
