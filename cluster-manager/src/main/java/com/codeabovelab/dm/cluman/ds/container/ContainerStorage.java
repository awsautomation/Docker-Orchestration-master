
package com.codeabovelab.dm.cluman.ds.container;

import com.codeabovelab.dm.cluman.model.ContainerBaseIface;

import java.util.List;

public interface ContainerStorage {

    List<ContainerRegistration> getContainers();
    ContainerRegistration getContainer(String id);

    /**
     * Find container by 'cluster:name' too.
     * @param name
     * @return find registration or null
     */
    ContainerRegistration findContainer(String name);
    List<ContainerRegistration> getContainersByNode(String nodeName);

    /**
     * It also create container if it unexists.
     * @param container container
     * @param node node
     * @return container registration
     */
    ContainerRegistration updateAndGetContainer(ContainerBaseIface container, String node);

    /**
     * Note that it only delete container from storage, not from cluster.
     * @param id id of container
     */
    void deleteContainer(String id);
}
