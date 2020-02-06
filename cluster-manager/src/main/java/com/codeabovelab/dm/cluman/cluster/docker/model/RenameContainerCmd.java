
package com.codeabovelab.dm.cluman.cluster.docker.model;

import lombok.Data;

@Data
public class RenameContainerCmd {

    private String containerId;

    private String name;
}
