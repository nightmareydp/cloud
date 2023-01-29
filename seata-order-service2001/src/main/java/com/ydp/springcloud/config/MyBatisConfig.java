package com.ydp.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author YDP
 * @version 1.0
 * @date 2023/1/29 0:52
 */
@Configuration
@MapperScan({"com.ydp.springcloud.dao"})
public class MyBatisConfig {
}
