
package com.codeabovelab.dm.cluman.ui.msg;

import lombok.Data;

/**
 */
@Data
public class EventStats<E> {
    private final Object key;
    private final E lastEvent;
    private final int count;
}
