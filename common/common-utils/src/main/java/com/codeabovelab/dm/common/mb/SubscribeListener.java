

package com.codeabovelab.dm.common.mb;

import java.util.function.Consumer;

/**
 * Iface for listeners which listen subscribe/unsubscribe events
 */
public interface SubscribeListener<M> {
    /**
     *
     * @param bus
     * @param listener note that value may be wrapped listener, see {@link WrappedConsumer#unwrap(Consumer)}
     */
    void event(MessageBus<M> bus, Consumer<M> listener);
}
