

package com.codeabovelab.dm.common.push;

/**
 * Common iface for any command which can be stored in push module
 */
public interface PushSupport {
    /**
     * Id of command and also it used for {@link com.codeabovelab.dm.platform.push.ScheduledTask}
     * @return
     */
    String getId();

    /**
     * Configuration for schedule in push module
     * @return
     */
    PushConfig getPushConfig();
}
