
package com.codeabovelab.dm.cluman.ds.clusters;

/**
 */
public interface ClusterConfigFactory {
    AbstractNodesGroupConfig<?> create(ClusterCreationContext ccc);
}
