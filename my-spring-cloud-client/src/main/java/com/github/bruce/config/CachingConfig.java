package com.github.bruce.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * Used local redis cache
 *
 * The steps starting redis-server below:
 * First step : open redis root path '/Users/yandajun/software/develop/redis-4.0.8'
 * Second step : execute bin file 'src/redis-server'
 */
@Configuration
@EnableCaching
public class CachingConfig extends CachingConfigurerSupport {

    /**
     * Default cacheManager, expire after being written 60 seconds, 2000 limit of maximum size
     */
    @Primary
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder().maximumSize(2000).expireAfterWrite(60, TimeUnit.SECONDS));
        return cacheManager;
    }

    /**
     * Five-minutes cacheManager, expire after last access 5 seconds, 2000 maximum size
     */
    @Bean
    public CacheManager fiveSecondsCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder().maximumSize(2000).expireAfterAccess(5, TimeUnit.SECONDS));
        return cacheManager;
    }

    /**
     * Redis cacheManager, the value will expire after 60 seconds after being written
     */
    @Bean
    public CacheManager redisCacheManager(LettuceConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(60))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
        Map<String, RedisCacheConfiguration> particularConfigs = new HashMap<>();
        return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(defaultConfig).withInitialCacheConfigurations(particularConfigs).build();
    }

}