
package com.codeabovelab.dm.cluman.model;

import com.codeabovelab.dm.cluman.cluster.docker.management.result.ProcessEvent;
import lombok.Data;

import java.util.function.Consumer;

/**
 * Parameters required for creating new container
 */
@Data
public class CreateContainerArg {

    private Consumer<ProcessEvent> watcher;
    private ContainerSource container;
    private boolean enrichConfigs;

    public CreateContainerArg watcher(Consumer<ProcessEvent> watcher) {
        setWatcher(watcher);
        return this;
    }

    public CreateContainerArg container(ContainerSource container) {
        setContainer(container);
        return this;
    }

    public CreateContainerArg enrichConfigs(boolean enrichConfigs) {
        setEnrichConfigs(enrichConfigs);
        return this;
    }
}

