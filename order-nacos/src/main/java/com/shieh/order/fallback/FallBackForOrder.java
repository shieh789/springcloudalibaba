package com.shieh.order.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class FallBackForOrder {

    public static String fallBackForQueryOrder(Throwable throwable){
        throwable.printStackTrace();
        return "异常处理-----";
    }

}
