
package com.codeabovelab.dm.cluman.cluster.docker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * https://github.com/docker/docker/blob/a69c4129e086e4e7b86cce7d2682685dfdc6f2d2/api/types/types.go#L442
 */
@Data
public class ConnectNetworkCmd {

    /**
     * Name or id of network
     */
    @JsonIgnore
    private String network;

    /**
     * name or id of container
     */
    @JsonProperty("Container")
    private String container;

    /**
     * Configuration for a network endpoint.
     */
    @JsonProperty("EndpointConfig")
    private EndpointSettings config;
}
