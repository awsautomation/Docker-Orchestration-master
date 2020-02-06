

package com.codeabovelab.dm.common.mb;

import com.codeabovelab.dm.common.utils.Key;


public interface ExtensionFactory<T, M> {
    T create(Key<T> key, MessageBus<M> bus);
}
