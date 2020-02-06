

package com.codeabovelab.dm.common.cache;

import org.springframework.cache.Cache;

import java.util.Map;

/**
 * Iface for utility which invalidate specified cache
 */
public interface CacheInvalidator {

    /**
     * Invalidator which is do nothing.
     */
    class NullInvalidator implements CacheInvalidator {

        @Override
        public void init(Cache cache, Map<String, String> args) {
        }
    }

    /**
     * Method which bind invalidator with cache. Due to cache architecture limitations this method must
     * allow sequence invocation on same cache instance (i.e. idempotent).
     * @param cache
     * @param args
     */
    void init(Cache cache, Map<String, String> args);
}
