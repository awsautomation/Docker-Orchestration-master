

package com.codeabovelab.dm.cluman.cluster.docker.model;

import com.codeabovelab.dm.common.json.JtEnumLower;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;


@Data
public class UpdateNodeCmd {
    /**
     * Node id from swarm mode of docker. <p/>
     * Not confuse it with node name or address, it must be string like '24ifsmvkjbyhk'.
     */
    @JsonIgnore
    private String nodeId;

    @JsonIgnore
    private long version;

    /**
     * Name for the node.
     */
    @JsonProperty("Name")
    private String name;

    /**
     * User-defined key/value metadata.
     */
    @JsonProperty("Labels")
    private Map<String, String> labels;

    /**
     * Role of the node.
     */
    @JsonProperty("Role")
    private Role role;

    /**
     * Availability of the node.
     */
    @JsonProperty("Availability")
    private Availability availability;

    @JtEnumLower
    public enum Role {
        WORKER, MANAGER
    }

    @JtEnumLower
    public enum Availability {
        ACTIVE, PAUSE, DRAIN
    }
}
