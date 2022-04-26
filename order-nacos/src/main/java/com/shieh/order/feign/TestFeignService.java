package com.shieh.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-nacos",path = "/stock")
public interface TestFeignService {

    @RequestMapping("/test")
    public String test();
}
