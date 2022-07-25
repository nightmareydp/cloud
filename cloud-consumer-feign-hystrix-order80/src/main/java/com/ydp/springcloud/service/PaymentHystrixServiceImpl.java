package com.ydp.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author YDP
 * @version 1.0
 * @date 2022/7/25 21:23
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService{
    @Override
    public String paymentInfo(Integer id) {
        return "对方服务已宕机或出现异常，请稍后再试！！！";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "对方服务已宕机或出现异常，请稍后再试！！！";
    }
}
