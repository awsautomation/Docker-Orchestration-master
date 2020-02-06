

package com.codeabovelab.dm.common.kv.mapping;

import com.codeabovelab.dm.common.kv.KvStorageEvent;
import lombok.Data;

/**
 * Remote map event, mapped from @{@link KvStorageEvent}, do not confuse with {@link KvMapLocalEvent}
 */
@Data
public class KvMapEvent<T> {
    private final KvMap<T> map;
    private final KvStorageEvent.Crud action;
    private final String key;
    /**
     * Value can be null, if in not present in local cache.
     */
    private final T value;
}
