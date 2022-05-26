package com.aws.peachworld.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class CacheConfig extends CachingConfigurerSupport {

    /**
     * No CacheManager Bean
     */
    @Profile("test")
    @Bean
    public CacheManager noRedisCacheManager() {
        return new NoOpCacheManager();
    }

    /**
     * CacheManager Bean
     */
    @Profile("!test")
    @Bean
    public CacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration
            .defaultCacheConfig()
            .prefixCacheNameWith("VL::")
            .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));

        Map<String, RedisCacheConfiguration> redisCacheConfigMap = new HashMap<>();

        redisCacheConfigMap.put(CacheNameType.TTS_2, redisCacheConfiguration.entryTtl(Duration.ofMinutes(RedisTtsType.TTS_2.getValue())));
        redisCacheConfigMap.put(CacheNameType.TTS_5, redisCacheConfiguration.entryTtl(Duration.ofMinutes(RedisTtsType.TTS_5.getValue())));
        redisCacheConfigMap.put(CacheNameType.TTS_10, redisCacheConfiguration.entryTtl(Duration.ofMinutes(RedisTtsType.TTS_10.getValue())));

        redisCacheConfigMap.put(CacheNameType.TTS_15, redisCacheConfiguration.entryTtl(Duration.ofMinutes(RedisTtsType.TTS_15.getValue())));
        redisCacheConfigMap.put(CacheNameType.TTS_30, redisCacheConfiguration.entryTtl(Duration.ofMinutes(RedisTtsType.TTS_30.getValue())));
        redisCacheConfigMap.put(CacheNameType.TTS_60, redisCacheConfiguration.entryTtl(Duration.ofMinutes(RedisTtsType.TTS_60.getValue())));
        redisCacheConfigMap.put(CacheNameType.TTS_H12, redisCacheConfiguration.entryTtl(Duration.ofHours(RedisTtsType.TTS_H12.getValue())));
        redisCacheConfigMap.put(CacheNameType.TTS_D1, redisCacheConfiguration.entryTtl(Duration.ofDays(RedisTtsType.TTS_D1.getValue())));
        redisCacheConfigMap.put(CacheNameType.TTS_D7, redisCacheConfiguration.entryTtl(Duration.ofDays(RedisTtsType.TTS_D7.getValue())));
        redisCacheConfigMap.put(CacheNameType.TTS_UNLIMIT, redisCacheConfiguration);

        return RedisCacheManager.RedisCacheManagerBuilder
            .fromConnectionFactory(redisConnectionFactory)
            .cacheDefaults(redisCacheConfiguration)
            .withInitialCacheConfigurations(redisCacheConfigMap)
            .build();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return new CustomRedisCacheErrorHandler();
    }

    @Slf4j
    public static class CustomRedisCacheErrorHandler implements CacheErrorHandler {

        @Override
        public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
            log.error("Unable to get from cache. key: {}, name: {} - {}", key, cache.getName(), e.getMessage());
        }

        @Override
        public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
            log.error("Unable to put into cache. key: {}, name: {} - {}", key, cache.getName(), e.getMessage());
        }

        @Override
        public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
            log.error("Unable to evict from cache. key: {}, name: {} - {}", key, cache.getName(), e.getMessage());
        }

        @Override
        public void handleCacheClearError(RuntimeException e, Cache cache) {
            log.error("Unable to clean cache. name: {} - {}", cache.getName(), e.getMessage());
        }

    }

}
