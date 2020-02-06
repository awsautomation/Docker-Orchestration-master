

package com.codeabovelab.dm.common.kv.mapping;

import lombok.Data;

/**
 * Like {@link KvMapEvent }, but caused by local modifications, or processing of remote changes on local map.
 * For example, deletion key in KV cause remote events, and local event too if local map has value for this key.
 */
@Data
public class KvMapLocalEvent<T> {
    public enum Action {
        /**
         * save new value
         */
        CREATE,
        /**
         * save value over existed
         */
        UPDATE,
        /**
         * Delete existed value
         */
        DELETE,
        /**
         * Load existed value
         */
        LOAD
    }

    private final KvMap<T> map;
    private final Action action;
    private final String key;
    private final T oldValue;
    private final T newValue;
}
