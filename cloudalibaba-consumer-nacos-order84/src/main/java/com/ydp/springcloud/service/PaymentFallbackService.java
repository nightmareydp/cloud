package com.ydp.springcloud.service;

import com.ydp.springcloud.entities.CommonResult;
import com.ydp.springcloud.entities.Payment;

/**
 * @author YDP
 * @version 1.0
 * @date 2023/1/28 16:37
 */
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
