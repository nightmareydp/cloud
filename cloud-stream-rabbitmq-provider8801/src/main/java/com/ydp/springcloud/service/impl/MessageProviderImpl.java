package com.ydp.springcloud.service.impl;

import com.ydp.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;


/**
 * @author YDP
 * @version 1.0
 * @date 2022/9/18 22:06
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    /**
     * 发送消息
     *
     * @return null
     */
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("serial : {}", serial);
        return null;
    }
}
