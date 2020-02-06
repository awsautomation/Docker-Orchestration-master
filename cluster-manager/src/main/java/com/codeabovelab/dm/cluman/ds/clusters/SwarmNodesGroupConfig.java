
package com.codeabovelab.dm.cluman.ds.clusters;

import com.codeabovelab.dm.cluman.cluster.docker.ClusterConfigImpl;
import com.codeabovelab.dm.common.kv.mapping.KvMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SwarmNodesGroupConfig extends AbstractNodesGroupConfig<SwarmNodesGroupConfig> implements DockerBasedClusterConfig {
    @KvMapping
    private ClusterConfigImpl config;
}
