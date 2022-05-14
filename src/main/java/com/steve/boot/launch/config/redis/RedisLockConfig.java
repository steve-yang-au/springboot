package com.steve.boot.launch.config.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

/**
 * there are 2 ways to get a Rest-based lock:
 * 1. RedisLockRegistry是spring-integration-redis中提供redis分布式锁实现类
 * 2. 基于Redisson实现分布式锁原理（Redission是一个独立的redis客户端，是与Jedis、Lettuce同级别的存在）
 */
@Configuration
public class RedisLockConfig {

    @Bean
    public RedisLockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory) {
        //第一个参数redisConnectionFactory
        //第二个参数registryKey，分布式锁前缀，设置为项目名称会好些
        //该构造方法对应的分布式锁，默认有效期是60秒.可以自定义
        return new RedisLockRegistry(redisConnectionFactory, "boot-launch");
        //return new RedisLockRegistry(redisConnectionFactory, "boot-launch",60);
    }
}