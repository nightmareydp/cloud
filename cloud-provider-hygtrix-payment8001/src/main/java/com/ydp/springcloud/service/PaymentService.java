package com.ydp.springcloud.service;

/**
 * @author YDP
 * @version 1.0
 * @date 2022/6/27 22:03
 */
public interface PaymentService {

    /**
     * 正常访问-返回正确
     *
     * @param id id
     * @return 提示语
     */
    String paymentInfo(Integer id);

    /**
     * 超时访问-返回正确
     *
     * @param id id
     * @return 提示语
     */
    String paymentInfoTimeOut(Integer id);
}
