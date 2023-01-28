package com.ydp.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ydp.springcloud.entities.CommonResult;

/**
 * @author YDP
 * @version 1.0
 * @date 2023/1/28 15:50
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客戶自定义,global handlerException----2");
    }

}
