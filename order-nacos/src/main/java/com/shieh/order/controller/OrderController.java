package com.shieh.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.shieh.order.blockhandler.BlockHandlerForOrder;
import com.shieh.order.fallback.FallBackForOrder;
import com.shieh.order.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

    @Qualifier("com.shieh.order.feign.StockFeignService")
    StockFeignService stockFeignService;


    @RequestMapping("/queryOrder")
    @SentinelResource(value = "queryOrder",blockHandlerClass = BlockHandlerForOrder.class, blockHandler = "blockHandlerForQueryOrder",
    fallbackClass = FallBackForOrder.class,
    fallback = "fallBackForQueryOrder")
    public String queryOrder(){
        String msg = stockFeignService.reduceStock();
        return "查询订单"+msg;
    }

    @RequestMapping("/testRibbon")
    @SentinelResource(value = "testRibbon",blockHandlerClass = BlockHandlerForOrder.class, blockHandler = "blockHandlerForTestRibbon")
    public String testRibbon(){
        int sa=1/0;
        String test = stockFeignService.test();
        return test;
    }
}