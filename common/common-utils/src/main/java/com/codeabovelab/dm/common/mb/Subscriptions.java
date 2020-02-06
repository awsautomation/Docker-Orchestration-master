

package com.codeabovelab.dm.common.mb;

import com.codeabovelab.dm.common.utils.Key;

import java.util.function.Consumer;


public interface Subscriptions<M> extends SubscriptionsIface<M>, MessageBusInfo<M>  {

    static <T> Subscriptions<T> empty(String id, Class<T> type) {
        return new Subscriptions<T>() {
            @Override
            public String getId() {
                return id;
            }

            @Override
            public Class<T> getType() {
                return type;
            }

            @Override
            public void subscribe(Consumer<T> listener) {

            }

            @Override
            public void unsubscribe(Consumer<T> listener) {

            }

            @Override
            public <E> E getOrCreateExtension(Key<E> key, ExtensionFactory<E, T> factory) {
                return null;
            }

            @Override
            public <E> E getExtension(Key<E> key) {
                return null;
            }
        };
    }

    /**
     * Register specified extension in this bus. <p/>
     * Note that if extension is instance of {@link AutoCloseable } then it closed with bus.
     * @see #getExtension(Key)
     * @param key
     * @param factory
     * @param <T>
     * @return
     */
    <T> T getOrCreateExtension(Key<T> key, ExtensionFactory<T, M> factory);

    /**
     * Get specified extension from this bus.
     * @see #getOrCreateExtension(Key, ExtensionFactory)
     * @param key
     * @param <T>
     * @return
     */
    <T> T getExtension(Key<T> key);
}
