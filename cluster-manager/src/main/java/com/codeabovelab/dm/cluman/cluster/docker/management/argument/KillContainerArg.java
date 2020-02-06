

package com.codeabovelab.dm.cluman.cluster.docker.management.argument;

import com.codeabovelab.dm.cluman.cluster.docker.management.DockerService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

/**
 * Argument for {@link DockerService#killContainer(KillContainerArg)}
 */
@Builder
@Data
public class KillContainerArg {
    public enum Signal {
        SIGINT,
        SIGQUIT,
        SIGABRT,
        SIGKILL,
        SIGTERM,
        SIGTSTP,
        SIGSTOP,
        SIGCONT,
        SIGTTIN,
        SIGTTOU
    }

    /**
     * Container ID
     */
    @JsonIgnore
    private final String id;

    /**
     * default SIGKILL
     * @return
     */
    private final Signal signal;

}
