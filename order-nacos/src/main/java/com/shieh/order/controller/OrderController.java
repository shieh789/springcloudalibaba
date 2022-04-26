package com.shieh.order.controller;

import com.shieh.order.feign.StockFeignService;
import com.shieh.order.feign.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

    @Autowired
    StockFeignService stockFeignService;

    @Value("${user.password}")
    private String configStr;

    @Value("${student.name}")
    private String testStr;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    TestFeignService testFeignService;

    @RequestMapping("/queryOrder")
    public String queryOrder(){
        String msg = stockFeignService.reduceStock();
        System.out.println("配置文本:"+configStr+"======"+testStr);
        return "查询订单"+msg+configStr;
    }

    @RequestMapping("/testRibbon")
    public String testRibbon(){
        //String forObject = restTemplate.getForObject("http://stock-nacos/stock/test", String.class);
        //return forObject;
        String test = testFeignService.test();
        return test;
    }
}
