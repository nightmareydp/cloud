package com.ydp.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ydp.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    //-------------------------服务熔断-------------------------

    /**
     * 服务熔断方法
     *
     * @param id id
     * @return 提示语
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后开启断路器
    })
    @Override
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    /**
     * 服务熔断-降级方法
     *
     * @param id id
     * @return 提示语
     */
    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }


}
