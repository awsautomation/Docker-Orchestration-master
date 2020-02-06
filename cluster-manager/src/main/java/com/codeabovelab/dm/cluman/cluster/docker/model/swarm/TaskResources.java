

package com.codeabovelab.dm.cluman.cluster.docker.model.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * https://github.com/docker/docker/blob/a5da9f5cc911da603a41bb77ca1ccbb0848d6260/api/types/swarm/task.go#L70
 */
@Data
@AllArgsConstructor
@Builder(builderClassName = "Builder")
public class TaskResources {

    /**
     * CPU limit in units of 10^-9 CPU shares.
     */
    @JsonProperty("NanoCPUs")
    private final long nanoCPUs;

    @JsonProperty("MemoryBytes")
    private final long memory;
}
