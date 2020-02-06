

package com.codeabovelab.dm.common.utils;

/**
 * list of common message headers constants.
 */
public final class MessageHeaders {
    private MessageHeaders() {
    }

    /**
     * Header with host where message was generated.
     * @see OSUtils#getHostName()
     */
    public static final String HOST = "host";

}
