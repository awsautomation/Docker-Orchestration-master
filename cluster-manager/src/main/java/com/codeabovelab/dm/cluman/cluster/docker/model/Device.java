
package com.codeabovelab.dm.cluman.cluster.docker.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import static com.google.common.base.Preconditions.checkNotNull;

@JsonInclude(Include.NON_NULL)
@Data
public class Device {

    @JsonProperty("CgroupPermissions")
    private String cGroupPermissions = "";

    @JsonProperty("PathOnHost")
    private String pathOnHost = null;

    @JsonProperty("PathInContainer")
    private String pathInContainer = null;

    public Device() {
    }

    public Device(String cGroupPermissions, String pathInContainer, String pathOnHost) {
        checkNotNull(cGroupPermissions, "cGroupPermissions is null");
        checkNotNull(pathInContainer, "pathInContainer is null");
        checkNotNull(pathOnHost, "pathOnHost is null");
        this.cGroupPermissions = cGroupPermissions;
        this.pathInContainer = pathInContainer;
        this.pathOnHost = pathOnHost;
    }

}