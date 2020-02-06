

package com.codeabovelab.dm.common.kv;

import lombok.Data;

/**
 * DockerEvent of key value storage.
 */
@Data
public class KvStorageEvent {

    /**
     * Index of node
     */
    private final long index;
    private final String key;
    private final String value;
    private final long ttl;
    private final Crud action;
    public KvStorageEvent(long index, String key, String value, long ttl, Crud action) {
        this.index = index;
        this.key = key;
        this.value = value;
        this.ttl = ttl;
        this.action = action;
    }

    public enum Crud {
        CREATE, READ, UPDATE, DELETE
    }

}
