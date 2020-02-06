
package com.codeabovelab.dm.gateway.api;

import com.codeabovelab.dm.common.gateway.ClientConnection;

/**
 * Invoked at connection close
 */
public interface ConnectionCloseCallback {
    void connectionClose(ClientConnection connection);
}
