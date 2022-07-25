package com.ydp.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ydp.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author YDP
 * @version 1.0
 * @date 2022/7/16 17:25
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class OrderHystirxController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    /**
     * 正常访问-返回正确
     *
     * @param id id
     * @return 提示语
     */
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo(id);
        return result;
    }

    /**
     * 超时访问-返回正确
     *
     * @param id id
     * @return 提示语
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    // @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
    //         @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    // })
    @HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoTimeOut(id);
        return result;
    }

    /**
     * 服务降级方法
     *
     * @param id id
     * @return 提示语句
     */
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己";
    }

    /**
     * 全局异常降级方法
     *
     * @return 提示语句
     */
    public String globalFallbackMethod(){
        return "全局异常降级方法，请稍后再试！！！";
    }

}
