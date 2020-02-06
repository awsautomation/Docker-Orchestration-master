

package com.codeabovelab.dm.common.mb;

import java.util.function.Consumer;


public interface ConditionalSubscriptions<M, K> extends Subscriptions<M> {

    /**
     * Subscribe on specified keys
     * @param listener
     * @param key event key, what part of event is key depend from key extractor function
     */
    void subscribeOnKey(Consumer<M> listener, K key);

    /**
     * Act like {@link #subscribe(Consumer)}, but return closeable which is doing unsubcription.
     * @param listener
     * @param key event key, what part of event is key depend from key extractor function
     * @return
     */
    default Subscription openSubscriptionOnKey(Consumer<M> listener, K key) {
        subscribe(listener);
        return new SubscriptionImpl<>(this, listener);
    }
}
