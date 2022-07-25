package com.ydp.springcloud.service;

import com.ydp.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;


/**
 * @author YDP
 * @version 1.0
 * @date 2022/5/30 23:49
 */
public interface PaymentService {

    /**
     * 新增支付
     *
     * @param payment 支付
     * @return 成功数量
     */
    int create(Payment payment);

    /**
     * 根据id获取信息
     *
     * @param id id
     * @return 实体信息
     */
    Payment getPaymentById(@Param("id") Long id);
}
