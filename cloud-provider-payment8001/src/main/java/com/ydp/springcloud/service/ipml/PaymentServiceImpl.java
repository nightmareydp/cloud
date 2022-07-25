package com.ydp.springcloud.service.ipml;

import com.ydp.springcloud.dao.PaymentDao;
import com.ydp.springcloud.entities.Payment;
import com.ydp.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author YDP
 * @version 1.0
 * @date 2022/5/31 0:06
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
