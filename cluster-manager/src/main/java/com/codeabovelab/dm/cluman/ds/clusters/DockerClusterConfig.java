
package com.codeabovelab.dm.cluman.ds.clusters;

import com.codeabovelab.dm.cluman.cluster.docker.ClusterConfigImpl;
import com.codeabovelab.dm.cluman.cluster.docker.model.swarm.SwarmSpec;
import com.codeabovelab.dm.common.kv.mapping.KvMapping;
import com.codeabovelab.dm.common.utils.Cloneables;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Do not confuse with {@link SwarmNodesGroupConfig} because it may contain part of {@link SwarmSpec}.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DockerClusterConfig extends AbstractNodesGroupConfig<DockerClusterConfig> implements DockerBasedClusterConfig {
    @KvMapping
    private ClusterConfigImpl config;
    @KvMapping
    private int swarmPort = 4375;
    /**
     * List of managers nodes.
     */
    @NotNull
    @Size(min = 1)
    @KvMapping
    private List<String> managers;

    @Override
    public DockerClusterConfig clone() {
        DockerClusterConfig clone = super.clone();
        clone.managers = Cloneables.clone(clone.managers);
        return clone;
    }
}
