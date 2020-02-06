
package com.codeabovelab.dm.cluman.cluster.docker.management.argument;

import lombok.Data;

/**
 * Argument for get containers method
 */
@Data
public class GetContainersArg {

    private final boolean all;

    public GetContainersArg(boolean all) {
        this.all = all;
    }
}
