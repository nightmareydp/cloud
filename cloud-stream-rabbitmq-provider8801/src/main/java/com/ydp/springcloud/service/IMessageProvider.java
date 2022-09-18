package com.ydp.springcloud.service;

/**
 * 消息生产接口
 *
 * @author YDP
 * @version 1.0
 * @date 2022/9/18 22:02
 */
public interface IMessageProvider {

    /**
     * 发送消息
     *
     * @return null
     */
    String send();
}
