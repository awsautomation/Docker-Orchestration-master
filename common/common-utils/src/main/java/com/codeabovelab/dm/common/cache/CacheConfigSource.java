

package com.codeabovelab.dm.common.cache;

/**
 */
public interface CacheConfigSource {
    String getName();

    /**
     * Timeout after last writing, after that cached value is expired.
     * Zero value mean that cache never expired, negative value - that cache managed must use default value.
     * @return
     */
    long getExpireAfterWrite();
}
