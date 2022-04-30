package com.shieh.order.blockhandler;


import com.alibaba.csp.sentinel.slots.block.BlockException;


public class BlockHandlerForOrder {


    public static String blockHandlerForQueryOrder(BlockException exception){
        exception.getStackTrace();
        return "流控1-----";
    }


    public static String blockHandlerForTestRibbon(BlockException exception){
        exception.getStackTrace();
        return "流控2-----";
    }
}
