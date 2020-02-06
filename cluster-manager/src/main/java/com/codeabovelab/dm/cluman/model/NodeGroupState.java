
package com.codeabovelab.dm.cluman.model;

import lombok.Builder;
import lombok.Data;

/**
 */
@Data
@Builder(builderClassName = "Builder")
public class NodeGroupState {
    private final String message;
    private final boolean ok;
    private final boolean inited;
}
