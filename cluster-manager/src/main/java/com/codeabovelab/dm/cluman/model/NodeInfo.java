
package com.codeabovelab.dm.cluman.model;

/**
 */
public interface NodeInfo extends Node, Labels, WithCluster {
    /**
     * version of node record, user on update requests.
     * @return
     */
    long getVersion();

    /**
     * Note that this id generated at join node to cluster, and can be changed any time,
     * therefore you can not identity node by this. It need used only for swarm-mode operations.
     * @return id or null
     */
    String getIdInCluster();

    /**
     * Flag which show that node now is power up and online. It not
     * meant that node is health or not.
     * @return
     */
    boolean isOn();

    /**
     * Real cluster which own this node. <p/>
     * Note that it may be null, also, over time it may not reflect actual state. So this value
     * is actual only when this object was created.
     * @see DiscoveryStorage#getClusterForNode(String)
     * @return name of real cluster or null.
     */
    @Override
    String getCluster();

    /**
     * May be null, also see {@link NodeMetrics#getTime()}, because it may be outdated.
     * @return
     */
    NodeMetrics getHealth();
}
