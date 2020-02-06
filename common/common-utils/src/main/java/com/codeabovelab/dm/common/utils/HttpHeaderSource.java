

package com.codeabovelab.dm.common.utils;

import java.util.Iterator;

/**
 * Abstract http header source
 */
public interface HttpHeaderSource {
    /**
     * Return the iterator over header name.
     * @return
     */
    Iterator<String> iterateNames();

    /**
     * Get value associated with specified name.
     * @param name
     * @return
     */
    String getValue(String name);
}
