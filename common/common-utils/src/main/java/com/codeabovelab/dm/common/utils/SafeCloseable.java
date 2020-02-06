
package com.codeabovelab.dm.common.utils;

/**
 * Variant of {@link AutoCloseable } without checked exceptions.
 */
public interface SafeCloseable extends AutoCloseable {
    @Override
    void close();
}
