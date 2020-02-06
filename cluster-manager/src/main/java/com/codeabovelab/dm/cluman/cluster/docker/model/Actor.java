

package com.codeabovelab.dm.cluman.cluster.docker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Actor {

    @JsonProperty("ID")
    private String id;

    @JsonProperty("Attributes")
    private Map<String, String> attributes;
}
