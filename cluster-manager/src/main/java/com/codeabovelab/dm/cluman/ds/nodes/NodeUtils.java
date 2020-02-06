
package com.codeabovelab.dm.cluman.ds.nodes;

import com.codeabovelab.dm.cluman.cluster.docker.management.DockerService;
import com.codeabovelab.dm.cluman.ds.container.ContainerRegistration;
import com.codeabovelab.dm.cluman.ds.container.ContainerStorage;
import com.codeabovelab.dm.cluman.validate.ExtendedAssert;
import com.google.common.net.InternetDomainName;

public class NodeUtils {
    private NodeUtils() {
    }

    /**
     * Node name must be valid host name. In this method we check it.
     * @param name
     */
    public static void checkName(String name) {
        InternetDomainName.from(name);
    }

    public static DockerService getDockerByContainer(ContainerStorage containers, NodeStorage nodes, String containerId) {
        ContainerRegistration container = containers.getContainer(containerId);
        ExtendedAssert.notFound(container, "Can't find container by id " + containerId);
        return nodes.getNodeService(container.getNode());
    }

}
