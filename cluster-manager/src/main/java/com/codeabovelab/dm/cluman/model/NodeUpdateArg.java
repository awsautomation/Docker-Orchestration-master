
package com.codeabovelab.dm.cluman.model;

import com.codeabovelab.dm.cluman.cluster.docker.model.UpdateNodeCmd;
import lombok.Data;

import java.util.Map;

/**
 */
@Data
public class NodeUpdateArg {
    /**
     * Code from 'node.version'
     */
    private long version;
    private String node;

    private Map<String, String> labels;

    /**
     * Role of the node.
     */
    private UpdateNodeCmd.Role role;

    /**
     * Availability of the node.
     */
    private UpdateNodeCmd.Availability availability;

}
