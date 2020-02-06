

package com.codeabovelab.dm.common.gateway;

/**
 * Simple text message iface.
 * @see ClientConnection#send(Object)
 */
public interface TextMessage {

    String getTitle();

    String getMessage();
}
