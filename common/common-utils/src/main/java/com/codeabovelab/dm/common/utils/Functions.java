

package com.codeabovelab.dm.common.utils;

import java.util.function.Function;

/**
 */
public class Functions {
    private static final Function<Object, Object> DIRECT = arg -> arg;

    private static final Function<Object, Object> NULL = arg -> null;

    /**
     * Function which return its argument.
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Function<T, T> directFunc() {
        return (Function<T, T>) DIRECT;
    }

    /**
     * Function which return null.
     * @param <A>
     * @param <V>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <A, V> Function<A, V> nullFunc() {
        return (Function<A, V>) NULL;
    }

    /**
     * This is some hack which allow us to process any types of arguments with single generic function. Also it
     * frees us from check interceptor for null.
     * @param interceptor
     * @param arg
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T intercept(Function<Object, Object> interceptor, T arg) {
        if(interceptor == null) {
            return arg;
        }
        Object res = interceptor.apply(arg);
        return (T) res;
    }
}
