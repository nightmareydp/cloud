package com.ydp.springcloud.service;

import com.ydp.springcloud.entities.CommonResult;
import com.ydp.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author YDP
 * @version 1.0
 * @date 2022/6/18 23:23
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 根据id查询
     * @param id id
     * @return 业务信息
     */
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 模拟业务接口超时
     * @return 服务端口号
     */
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();

}
