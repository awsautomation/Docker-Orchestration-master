
package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.cluman.cluster.docker.model.ContainerDetails;
import com.codeabovelab.dm.cluman.cluster.docker.model.ContainerState;
import com.codeabovelab.dm.cluman.cluster.docker.model.HostConfig;
import com.codeabovelab.dm.cluman.cluster.docker.model.RestartPolicy;
import com.codeabovelab.dm.cluman.model.ContainerSource;
import com.codeabovelab.dm.cluman.model.DockerContainer;
import com.codeabovelab.dm.cluman.source.ContainerSourceFactory;
import com.codeabovelab.dm.cluman.ui.UiUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * Container details. Must strong complement with {@link ContainerSource } for filling UI forms with default
 * values and etc.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UIContainerDetails extends ContainerSource implements UiContainerIface, WithUiPermission {

    private Date created;
    private Date started;
    private Date finished;
    @Deprecated
    private List<String> args;
    private Integer restartCount;
    private boolean lock;
    private String lockCause;
    private boolean run;
    private String status;
    private DockerContainer.State state;
    private UiPermission permission;

    public UIContainerDetails() {
    }

    public UIContainerDetails from(ContainerSourceFactory containerSourceFactory, ContainerDetails container) {
        containerSourceFactory.toSource(container, this);
        setId(container.getId());
        UiUtils.resolveContainerLock(this, container);
        setArgs(container.getArgs());
        setRestartCount(container.getRestartCount());
        ContainerState state = container.getState();
        setStatus(state.getStatus());
        setRun(state.isRunning());
        setCreated(container.getCreated());
        setStarted(state.getStartedAt());
        setFinished(state.getFinishedAt());
        HostConfig hostConfig = container.getHostConfig();
        if (hostConfig != null) {
            RestartPolicy restartPolicy = hostConfig.getRestartPolicy();
            setRestart(restartPolicy != null ? restartPolicy.toString() : null);
            setPublishAllPorts(Boolean.TRUE.equals(hostConfig.getPublishAllPorts()));
        }
        return this;
    }
}
