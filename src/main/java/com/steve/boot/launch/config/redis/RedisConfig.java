package com.steve.boot.launch.config.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "caching")  //application.yml配置前缀
public class RedisConfig {

    @Resource
    RedisProperties redisProperties;

    //自定义redisCacheManager
    @Bean
    public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate) {

        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter,
                this.buildRedisCacheConfigurationWithTTL(redisTemplate, RedisCacheConfiguration.defaultCacheConfig().getTtl().getSeconds()),  //默认的redis缓存配置
                this.getRedisCacheConfigurationMap(redisTemplate)); //针对每一个cache做个性化缓存配置
        return  redisCacheManager;
    }

    //配置注入，key是缓存名称，value是缓存有效期
    private Map<String,Long> ttlmap;  //lombok提供getset方法

    //根据ttlmap的属性装配结果，个性化RedisCacheConfiguration
    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap(RedisTemplate redisTemplate) {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();

        for(Map.Entry<String, Long> entry : ttlmap.entrySet()){
            String cacheName = entry.getKey();
            Long ttl = entry.getValue();
            redisCacheConfigurationMap.put(cacheName,this.buildRedisCacheConfigurationWithTTL(redisTemplate,ttl));
        }

        return redisCacheConfigurationMap;
    }

    /**
     *
     * 根据传参构建缓存配置
     * because the fields of RedisCacheConfiguration are "final", so we can only build its object once, any build by
     * its reference will be failed.
     */
    private RedisCacheConfiguration buildRedisCacheConfigurationWithTTL(RedisTemplate redisTemplate,Long ttl){
        if(redisProperties.getUseKeyPrefix() && !redisProperties.getCacheNullValues()){
            return RedisCacheConfiguration.defaultCacheConfig()
                    .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer()))
                    .entryTtl(Duration.ofSeconds(ttl)).prefixCacheNameWith(redisProperties.getKeyPrefix()).disableCachingNullValues();
        }else if(redisProperties.getUseKeyPrefix() ){
            return RedisCacheConfiguration.defaultCacheConfig()
                    .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer()))
                    .entryTtl(Duration.ofSeconds(ttl)).prefixCacheNameWith(redisProperties.getKeyPrefix());
        }
        return RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer()))
                .entryTtl(Duration.ofSeconds(ttl));
    }

}