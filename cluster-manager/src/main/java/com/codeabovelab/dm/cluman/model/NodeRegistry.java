
package com.codeabovelab.dm.cluman.model;

import com.codeabovelab.dm.cluman.cluster.docker.management.DockerService;

/**
 */
public interface NodeRegistry {
    DockerService getNodeService(String name);

}
