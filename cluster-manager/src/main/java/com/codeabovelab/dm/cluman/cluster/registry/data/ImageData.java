
package com.codeabovelab.dm.cluman.cluster.registry.data;

import com.codeabovelab.dm.cluman.cluster.docker.model.ContainerConfig;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 */
@Data
public class ImageData {
    private String architecture;
    private String author;
    private ContainerConfig config;
    @JsonProperty("container_config")
    private ContainerConfig containerConfig;
    private Date created;
    @JsonProperty("docker_version")
    private String dockerVersion;
    private String os;
    // we do not need this yet
    //private List<HistoryEntry> history;

}
