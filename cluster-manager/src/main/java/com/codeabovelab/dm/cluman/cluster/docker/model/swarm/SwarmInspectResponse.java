
package com.codeabovelab.dm.cluman.cluster.docker.model.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Result of 'GET /swarm'
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SwarmInspectResponse extends Cluster {

    @JsonProperty("JoinTokens")
    private JoinTokens joinTokens;

}
