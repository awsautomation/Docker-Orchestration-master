
package com.codeabovelab.dm.common.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

/**
 * Cache manager which expose common api for configuration of caches.
 */
public interface ConfigurableCacheManager extends CacheManager {
    /**
     * Provide default config for caches which will be created through {@link #getCache(String)}
     * @return
     */
    CacheConfig getDefaultConfiguration();

    /**
     * Retrieve or create cache for specified config. If cache has been created
     * through {@link #getCache(String)} it can have different config, and if then retrieved through current method
     * the error will be thrown.
     * @param config
     * @return
     */
    Cache getCache(CacheConfig config);
}
