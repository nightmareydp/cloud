package com.ydp.springcloud.controller;

import com.ydp.springcloud.domain.CommonResult;
import com.ydp.springcloud.domain.Order;
import com.ydp.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author YDP
 * @version 1.0
 * @date 2023/1/29 0:49
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

}
