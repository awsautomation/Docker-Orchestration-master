
package com.codeabovelab.dm.cluman.model;

import lombok.Data;

/**
 * Network interface counter
 */
@Data
public class NetIfaceCounter {
    private final String name;
    private final long bytesIn;
    private final long bytesOut;
}
