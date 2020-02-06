
package com.codeabovelab.dm.cluman.cluster.docker.management.argument;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

/**
 */
@Data
@Builder(builderClassName = "Builder")
public class DeleteContainerArg {

    /**
     * Container ID
     */
    @JsonIgnore
    private final String id;

    /**
     * Remove the volumes associated to the container. Default false.
     */
    private final boolean deleteVolumes;
    /**
     * Kill container if it run. Default false.
     */
    private final boolean kill;

}
