

package com.codeabovelab.dm.common.utils;

/**
 */
public class Comparables {
    /**
     * Compare comparable objects, correct handle nulls.
     * @return
     */
    public static <T extends Comparable<T>> int compare(T left, T right) {
        if(left == right) {
            return 0;
        }
        if(left == null) {
            return -1;
        }
        if(right == null) {
            return 1;
        }
        return left.compareTo(right);
    }
}
