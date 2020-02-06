
package com.codeabovelab.dm.common.utils;

public final class ArrayUtils {

    /**
     * Test that array null or empty.
     * @param array
     * @param <T>
     * @return
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * Test that array null or empty.
     * @param array
     * @return
     */
    public static boolean isEmpty(byte[] array) {
        return array == null || array.length == 0;
    }
}
