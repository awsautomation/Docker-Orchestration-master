
package com.codeabovelab.dm.cluman.cluster.docker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Used in {@link Container}
 *
 * @see Container
 * @author Kanstantsin Shautsou
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ContainerHostConfig {
    @JsonProperty("NetworkMode")
    private String networkMode;

}