

package com.codeabovelab.dm.common.mb;

import java.util.function.Consumer;

/**
 * Variant of {@link AutoCloseable }, but without checked exceptions.
 */
public interface Subscription extends AutoCloseable {

    /**
     * Give consumer which is used for this subscription
     * @return
     */
    Consumer<?> getConsumer();

    @Override
    void close();
}
