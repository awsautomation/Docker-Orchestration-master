
package com.codeabovelab.dm.cluman.model;

import lombok.Builder;
import lombok.Data;

/**
 */
@Data
@Builder
public class NodeImpl implements Node {
    private final String id;
    private final String name;
    private final String address;
    private final String environment;
}
