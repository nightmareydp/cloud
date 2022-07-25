package com.ydp.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ydp.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author YDP
 * @version 1.0
 * @date 2022/6/27 22:05
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问-返回正确
     *
     * @param id id
     * @return 提示语
     */
    @Override
    public String paymentInfo(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfo_OK,id:  " + id + "\t" + "哈哈哈";
    }

    /**
     * 超时访问-返回正确
     *
     * @param id id
     * @return 提示语
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    @Override
    public String paymentInfoTimeOut(Integer id) {
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // int age = 10/0;
        return "线程池:  " + Thread.currentThread().getName() + " id:  " + id + "\t" + "哈哈哈" + "  耗时(秒): 3";
    }

    /**
     * 服务降级方法
     *
     * @param id id
     * @return 提示语
     */
    public String paymentInfoTimeOutHandler(Integer id)
    {
        return "线程池:  "+Thread.currentThread().getName()+"  8001系统繁忙或者运行报错，请稍后再试";
    }


}
