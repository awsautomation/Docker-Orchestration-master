
package com.codeabovelab.dm.cluman.cluster.registry.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * History stores unstructured v1 compatibility information
 * history data temporary disabled because v1Compatibility is not json but string
 */
public class History {

    private final static String V1 = "v1Compatibility";

    private String layer;

    @JsonProperty(V1)
    public String getHistory() {
        return layer;
    }

    @JsonProperty(V1)
    public void setHistory(String history) {
        this.layer = history;
    }
}
