

package com.codeabovelab.dm.common.gateway;

import java.util.Set;

/**
 * Connection info.
 */
public interface ConnectionInfo {

    /**
     * Set of the most basic types supported by underlying connection protocol.
     * @see com.codeabovelab.dm.common.gateway.TextMessage
     * @return
     */
    Set<Class<?>> getSupportedMessages();
}
