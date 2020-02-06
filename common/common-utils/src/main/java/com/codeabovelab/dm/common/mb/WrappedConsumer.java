

package com.codeabovelab.dm.common.mb;

import java.util.function.Consumer;

/**
 */
public interface WrappedConsumer<T> extends Consumer<T>, AutoCloseable {
    /**
     * Return internal object, which is wrapped by this.
     * @return
     */
    Consumer<T> unwrap();

    /**
     * Used when bus contains listener wrappers, note that must correct work if argument is not an wrapper.
     * @param src
     * @param <M>
     * @return
     */
    static <M> Consumer<M> unwrap(Consumer<M> src) {
        Consumer<M> tmp = src;
        while(tmp instanceof WrappedConsumer) {
            tmp = ((WrappedConsumer<M>) tmp).unwrap();
            if(tmp == null) {
                throw new IllegalArgumentException("Null consumer in " + src);
            }
        }
        return tmp;
    }
}
