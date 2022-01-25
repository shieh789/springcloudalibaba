package com.shieh.order.controller;

import com.shieh.order.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    StockFeignService stockFeignService;


    @RequestMapping("/queryOrder")
    public String queryOrder(){
        String msg = stockFeignService.reduceStock();
        return "查询订单"+msg;
    }

}
