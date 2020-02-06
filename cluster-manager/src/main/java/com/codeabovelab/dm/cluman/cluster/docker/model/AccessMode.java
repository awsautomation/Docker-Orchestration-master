

package com.codeabovelab.dm.cluman.cluster.docker.model;

/**
 * The access mode of a file system or file: <code>read-write</code> or <code>read-only</code>.
 */
public enum AccessMode {
    /** read-write */
    rw,

    /** read-only */
    ro;

    /**
     * The default {@link AccessMode}: {@link #rw}
     */
    public static final AccessMode DEFAULT = rw;

    public static AccessMode fromBoolean(boolean accessMode) {
        return accessMode ? rw : ro;
    }

    public final boolean toBoolean() {
        return this.equals(AccessMode.rw);
    }

}