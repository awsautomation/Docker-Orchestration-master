
package com.codeabovelab.dm.cluman.ds.clusters;

import com.codeabovelab.dm.cluman.cluster.docker.ClusterConfigImpl;

/**
 */
public interface DockerBasedClusterConfig extends NodesGroupConfig {
    ClusterConfigImpl getConfig();
    void setConfig(ClusterConfigImpl config);
}
