

package com.codeabovelab.dm.common.mb;

import java.util.function.Consumer;

public interface MessageBus<M> extends Consumer<M>, Subscriptions<M>, AutoCloseable {
  
    Subscriptions<M> asSubscriptions();

    boolean isEmpty();
}
