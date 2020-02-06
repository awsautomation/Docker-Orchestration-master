

package com.codeabovelab.dm.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A util for closeables (you can se many similar utilites in guava and apache common-io, but we need some logging)
 */
public final class Closeables {

    private static final Logger LOG = LoggerFactory.getLogger(Closeables.class);

    /**
     * silently close closeable, catch any exception and write it to log
     * @param autoCloseable or null
     */
    public static void close(AutoCloseable autoCloseable) {
        if(autoCloseable == null) {
            return;
        }
        try {
            autoCloseable.close();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            LOG.error("On close.", e);
        }
    }

    /**
     * Close specified object if it is instance of AutoCloseable
     * @param mayBeCloseable
     */
    public static void closeIfCloseable(Object mayBeCloseable) {
        if(mayBeCloseable instanceof AutoCloseable) {
            close((AutoCloseable) mayBeCloseable);
        }
    }

    /**
     * Apply {@link #close(AutoCloseable)} to each items in collection.
     * @param closeables any iterable or null
     */
    public static void closeAll(Iterable<? extends AutoCloseable> closeables) {
        if(closeables == null) {
            return;
        }
        closeables.forEach(Closeables::close);
    }
}
