
package com.codeabovelab.dm.gateway.api;

import com.codeabovelab.dm.common.gateway.ConnectionEvent;

/**
 * Entry point for client events.
 */
public interface ConnectionEventListener {

    /**
     * Accept connection events.
     * @param event
     */
    void listen(ConnectionEvent event);
}
