package com.ydp.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义Ribbon轮询算法
 * @author YDP
 */
public interface LoadBalancer {

    /**
     * 选择实例
     * @param serviceInstances 服务实例list
     * @return 服务实例
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
