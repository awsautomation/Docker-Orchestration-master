
package com.codeabovelab.dm.cluman.cluster.docker.management.argument;

import lombok.Data;

/**
 */
@Data
public class SwarmLeaveArg {

    /**
     * 'Force leave swarm, even if this is the last manager or that it will break the cluster.' <p/>
     * Default 'false'.
     */
    private Boolean force;
}
