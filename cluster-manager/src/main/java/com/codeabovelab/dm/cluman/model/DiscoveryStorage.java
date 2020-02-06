
package com.codeabovelab.dm.cluman.model;

import com.codeabovelab.dm.cluman.cluster.docker.management.DockerService;
import com.codeabovelab.dm.cluman.ds.clusters.AbstractNodesGroupConfig;
import com.codeabovelab.dm.cluman.ds.clusters.ClusterConfigFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Hold clusters
 */
public interface DiscoveryStorage {

    String GROUP_ID_ALL = "all";
    String GROUP_ID_ORPHANS = "orphans";

    Collection<String> SYSTEM_GROUPS = Arrays.asList(GROUP_ID_ALL, GROUP_ID_ORPHANS);

    /**
     * Return exists cluster of concrete node.
     * @param node
     * @return cluster or null
     */
    NodesGroup getClusterForNode(String node);

    /**
     * Return exists cluster or null
     * @param clusterId
     * @return exists cluster or null
     */
    NodesGroup getCluster(String clusterId);

    /**
     *  Return existed cluster or create new.
     * @param clusterId name of cluster
     * @param factory factory or null
     * @return NodesGroup, never null
     */
    NodesGroup getOrCreateCluster(String clusterId, ClusterConfigFactory factory);

    /**
     * Register new group, or return already registered. Like {@link #getOrCreateCluster(String, ClusterConfigFactory)} but allow to
     * create node group and real clusters too.
     * @param config
     * @return registered node group.
     */
    NodesGroup getOrCreateGroup(AbstractNodesGroupConfig<?> config);

    void deleteCluster(String clusterId);

    void deleteNodeGroup(String clusterId);

    List<NodesGroup> getClusters();

    DockerService getService(String name);

    Set<String> getServices();
}
