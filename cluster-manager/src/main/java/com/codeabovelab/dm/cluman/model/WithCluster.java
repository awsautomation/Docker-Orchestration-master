
package com.codeabovelab.dm.cluman.model;

/**
 * Iface for objects with cluster name property. It needed for {@link com.codeabovelab.dm.cluman.cluster.filter.ClusterFilter }
 */
public interface WithCluster {
    String getCluster();
}
