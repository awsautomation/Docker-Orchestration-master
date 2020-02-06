
package com.codeabovelab.dm.cluman.cluster.registry.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Information about tags.
 */
@Data
public class Tag {

    private static final String NAME = "name"; // Name of the target repository.
    private static final String LAYER = "layer"; // ID of layer

    private final String name;
    private final String layer;

    public Tag(@JsonProperty(NAME) String name,
               @JsonProperty(LAYER) String layer) {
        this.name = name;
        this.layer = layer;
    }

    @JsonProperty(NAME)
    public String getName() {
        return name;
    }

    @JsonProperty(LAYER)
    public String getLayer() {
        return layer;
    }

}
