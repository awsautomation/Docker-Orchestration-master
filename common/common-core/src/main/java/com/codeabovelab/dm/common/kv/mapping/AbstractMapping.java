

package com.codeabovelab.dm.common.kv.mapping;

import com.codeabovelab.dm.common.kv.KeyValueStorage;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 */
abstract class AbstractMapping<T> {
    protected final Class<T> type;
    protected final KvMapperFactory mapper;

    AbstractMapping(KvMapperFactory mapper, Class<T> type) {
        this.mapper = mapper;
        this.type = type;
    }

    protected KeyValueStorage getStorage() {
        return this.mapper.getStorage();
    }

    protected ObjectMapper getObjectMapper() {
        return this.mapper.getObjectMapper();
    }

    abstract void save(String path, T object, KvSaveCallback callback);
    abstract void load(String path, T object);
    abstract <S extends T> S load(String path, String name, Class<S> type);
}
