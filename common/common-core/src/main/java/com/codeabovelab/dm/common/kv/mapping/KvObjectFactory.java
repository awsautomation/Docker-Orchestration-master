

package com.codeabovelab.dm.common.kv.mapping;

/**
 */
public interface KvObjectFactory<T> {
    T create(String key, Class<? extends T> type);
}
