
package com.codeabovelab.dm.common.cache;

import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * Common bean which can be used for configuration cache managers trough properties.
 * This class can not be final, because user can extent it.
 */
public class CacheManagerProperties extends CacheConfig.Builder {
    private Map<String, CacheConfig.Builder> caches;

    public void setCaches(Map<String, CacheConfig.Builder> caches) {
        this.caches = caches;
    }

    public Map<String, CacheConfig.Builder> getCaches() {
        return caches;
    }

    /**
     * It method configure caches defined in properties to cache manager.
     * @param cacheManager
     */
    public void configureCaches(ConfigurableCacheManager cacheManager) {
        if(CollectionUtils.isEmpty(this.caches)) {
            return;
        }
        for(Map.Entry<String, CacheConfig.Builder> entry: this.caches.entrySet()) {
            CacheConfig.Builder builder = entry.getValue();
            builder.setName(entry.getKey());
            cacheManager.getCache(builder.build());
        }
    }
}
