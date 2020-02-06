

package com.codeabovelab.dm.common.meter;

/**
 * Listener for limit excess events
 */
public interface LimitExcessListener {
    /**
     * will have invoked when any limit is exceeded
     * @param event
     */
    void listen(LimitExcessEvent event);
}
