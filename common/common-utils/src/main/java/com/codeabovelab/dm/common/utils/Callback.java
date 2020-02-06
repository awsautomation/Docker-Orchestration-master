

package com.codeabovelab.dm.common.utils;

/**
 * callback interface
 * <p/>Deprecated, use {@link java.util.function.Consumer }
 */
public interface Callback<T> {
    void call(T arg);
}
