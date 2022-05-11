package com.shieh.order.fallback;


import com.shieh.order.feign.StockFeignService;
import org.springframework.stereotype.Component;

@Component
public class FallBackForOrder implements StockFeignService {

    @Override
    public String reduceStock() {
        return "降级reduceStock啦-----";
    }

    @Override
    public String test() {
        return "降级test啦------";
    }
}
