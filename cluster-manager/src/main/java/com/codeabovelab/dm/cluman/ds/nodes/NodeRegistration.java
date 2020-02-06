
package com.codeabovelab.dm.cluman.ds.nodes;

import com.codeabovelab.dm.cluman.cluster.docker.management.DockerService;
import com.codeabovelab.dm.cluman.model.NodeInfo;
import com.codeabovelab.dm.common.mb.Subscriptions;
import org.springframework.security.acls.model.ObjectIdentity;

/**
 * Node registration in key value store, default implementation act as proxy, therefore may be changed in another thread.
 */
public interface NodeRegistration {
    NodeInfo getNodeInfo();

    /**
     * Name of cluster, can be null.
     * @see com.codeabovelab.dm.cluman.model.DiscoveryStorage#getClusterForNode(String)
     * @return name or null
     */
    String getCluster();

    /**
     * Time for node registration in seconds.
     * @return seconds or negative value when is not applicable.
     */
    int getTtl();

    Subscriptions<NodeHealthEvent> getHealthSubscriptions();

    ObjectIdentity getOid();

    DockerService getDocker();
}
