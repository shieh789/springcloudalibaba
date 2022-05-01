package com.shieh.order.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Feign远程调用接口
 */
@FeignClient(name = "stock-nacos",path = "/stock")
public interface StockFeignService {

    @RequestMapping("/reduce")
    public String reduceStock();


    @RequestMapping("/test")
    public String test();
}
