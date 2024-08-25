package com.sky.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author ZZHow
 * @date 2024/8/25
 */
@Slf4j
@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        log.info("开始创建 Redis 模版对象");

        // 创建 Redis 模版对象
        RedisTemplate redisTemplate = new RedisTemplate();
        // 设置 Redis 的连接工厂对象
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 设置 Redis key 的序列化器
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        // 返回 Redis 模版对象
        return redisTemplate;
    }

}
