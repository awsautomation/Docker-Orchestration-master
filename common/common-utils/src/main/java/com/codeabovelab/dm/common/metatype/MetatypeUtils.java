

package com.codeabovelab.dm.common.metatype;

import com.codeabovelab.dm.common.utils.Key;


public final class MetatypeUtils {
    private MetatypeUtils() {
    }

    /**
     * Create key from MetatypeInfo
     * @param mi
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Key<T> toKey(MetatypeInfo mi) {
        return (Key<T>) new Key<>(mi.name(), mi.type());
    }
}
