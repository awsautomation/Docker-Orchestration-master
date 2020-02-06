
package com.codeabovelab.dm.common.utils;

/**
 * Utilities for callbacks
 */
public final class Callbacks {

    /**
     * Callback which do 'No OPerations'. It usable for cases when null callback is not acceptable.
     */
    private static final Callback<Object> NOP_CALLBACK = arg -> { };

    /**
     * Invoke callback if it is not a null.
     * @param callback
     * @param value
     */
    public static <T> void call(Callback<T> callback, T value) {
        if(callback == null) {
            return;
        }
        callback.call(value);
    }

    /**
     * Callback which do 'No OPerations'. It usable for cases when null callback is not acceptable.
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Callback<T> nop() {
        return (Callback<T>) NOP_CALLBACK;
    }
}
