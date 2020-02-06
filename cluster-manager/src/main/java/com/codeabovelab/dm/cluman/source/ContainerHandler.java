
package com.codeabovelab.dm.cluman.source;

import com.codeabovelab.dm.cluman.cluster.docker.management.result.CreateAndStartContainerResult;
import com.codeabovelab.dm.cluman.model.ContainerSource;

/**
 */
interface ContainerHandler {
    ContainerHandler NOP = (cs, cr) -> {};

    void handle(ContainerSource containerSource, CreateAndStartContainerResult ccr);
}
