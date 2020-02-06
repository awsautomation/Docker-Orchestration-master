

package com.codeabovelab.dm.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 */
@Component
public class DmCachingConfigurer extends CachingConfigurerSupport {

    private final Map<String, CacheManager> cacheManagers;
    private final List<CacheInvalidator> cacheInvalidators;
    private CacheManager defaultCacheManager;

    @Autowired
    public DmCachingConfigurer(Map<String, CacheManager> cacheManagers, List<CacheInvalidator> cacheInvalidators) {
        this.cacheManagers = cacheManagers;
        this.cacheInvalidators = cacheInvalidators;
    }

    public CacheManager getDefaultCacheManager() {
        return defaultCacheManager;
    }

    @Autowired(required = false)
    public void setDefaultCacheManager(CacheManager defaultCacheManager) {
        this.defaultCacheManager = defaultCacheManager;
    }

    @Override
    public CacheResolver cacheResolver() {
        return new ConfigurableCacheResolver(this.cacheManagers, this.defaultCacheManager, cacheInvalidators);
    }
}
