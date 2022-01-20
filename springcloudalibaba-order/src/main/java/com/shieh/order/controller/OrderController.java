package com.shieh.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("/queryOrder")
    public String queryOrder(){
        System.out.println("query order");
        String msg = restTemplate.getForObject("http://stock-nacos/stock/reduce", String.class);
        return "查询订单"+msg;
    }

}
