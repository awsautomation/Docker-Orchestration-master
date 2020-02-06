
package com.codeabovelab.dm.cluman.cluster.docker.management.argument;

import com.google.common.util.concurrent.SettableFuture;

public interface WithInterrupter {
    /**
     * Handle for interrupt process
     * @return
     */
    SettableFuture<Boolean> getInterrupter();
}
