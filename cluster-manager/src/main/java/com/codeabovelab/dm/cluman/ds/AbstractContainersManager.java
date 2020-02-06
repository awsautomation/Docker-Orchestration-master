

package com.codeabovelab.dm.cluman.ds;

import com.codeabovelab.dm.cluman.cluster.docker.management.DockerService;
import com.codeabovelab.dm.cluman.model.ContainersManager;
import org.springframework.util.Assert;

import java.util.function.Supplier;

/**
 */
public abstract class AbstractContainersManager implements ContainersManager {
    protected final Supplier<DockerService> supplier;

    public AbstractContainersManager(Supplier<DockerService> supplier) {
        this.supplier = supplier;
    }

    protected DockerService getDocker() {
        DockerService service = supplier.get();
        Assert.notNull(service, "supplier " + supplier + " return null value");
        return service;
    }
}
