

package com.codeabovelab.dm.cluman.cluster.docker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 */
@Data
public class GetVolumesResponse {

    @JsonProperty("Volumes")
    private final List<Volume> volumes;

    @JsonProperty("Warnings")
    private final List<String> warnings;
}
