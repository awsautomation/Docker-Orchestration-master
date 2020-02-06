

package com.codeabovelab.dm.cluman.cluster.compose.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Logging {
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("options")
    private Map<String, Object> options;

}
