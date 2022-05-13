package com.steve.boot.launch.config.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.cache.redis")
public class RedisProperties {
    private Boolean cacheNullValues;
    private Boolean useKeyPrefix;
    private String keyPrefix;
}
