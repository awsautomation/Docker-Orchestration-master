

package com.codeabovelab.dm.platform.cache;
/*
import com.codeabovelab.dm.common.cache.CacheConfig;
import com.codeabovelab.dm.common.cache.ConfigurableCacheManager;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

public class ConfigurableRedisCacheManager extends RedisCacheManager implements ConfigurableCacheManager {

    private CacheConfig defaultCacheConfig;

    public ConfigurableRedisCacheManager(CacheConfig defaultCacheConfig, RedisTemplate template) {
        super(template);
    }

    @Override
    public CacheConfig getDefaultConfiguration() {
        if(defaultCacheConfig != null) {
            return defaultCacheConfig;
        }
        // terrible design of RedisCacheManager does not allow us to get 'defaultExpiration' field
        return CacheConfig.builder().expireAfterWrite(computeExpiration("")).build();
    }

    @Override
    public Cache getCache(CacheConfig config) {
        String name = config.getName();
        Assert.hasText(name);
        addCache(createCache(config));
        return super.getCache(name);
    }

    @SuppressWarnings("unchecked")
    private Cache createCache(CacheConfig config) {
        String cacheName = config.getName();
        long expireAfterWrite = config.getExpireAfterWrite();
        if(expireAfterWrite < 0) {
            expireAfterWrite = computeExpiration(cacheName);
        }
        return new RedisCache(cacheName, (isUsePrefix() ? getCachePrefix().prefix(cacheName) : null), getRedisOperations(), expireAfterWrite);
    }
}
*/
