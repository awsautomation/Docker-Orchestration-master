

package com.codeabovelab.dm.common.mb;

import java.util.function.Consumer;


public interface SubscriptionsIface<M> {

    /**
     * Method which subscribe specified listener on current bus. If listener already subscribed then doing nothing.
     * @param listener
     */
    void subscribe(Consumer<M> listener);

    /**
     * Act like {@link #subscribe(Consumer)}, but return closeable which is doing unsubcription.
     * @param listener
     * @return
     */
    default Subscription openSubscription(Consumer<M> listener) {
        subscribe(listener);
        return new SubscriptionImpl<>(this, listener);
    }

    /**
     * Method which unsubscribe specified listener from current bus. If listener not subscribed then doing nothing.
     * @param listener
     */
    void unsubscribe(Consumer<M> listener);
}
