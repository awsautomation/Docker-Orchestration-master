
package com.codeabovelab.dm.cluman.ds.clusters;

import lombok.Data;
import org.springframework.util.Assert;

import java.util.function.Consumer;

@Data
public class ClusterCreationContext {
    private final ClusterFactory factory;
    private final String cluster;
    private Consumer<AbstractNodesGroup<?>> beforeClusterInit;
    /**
     * Note: be careful when config loaded from storage - this cases must not
     * been validated, because user can not delete not loaded clusters.
     */
    private boolean mustValidated;

    ClusterCreationContext(ClusterFactory factory, String cluster) {
        this.factory = factory;
        this.cluster = cluster;
    }

    void beforeClusterInit(AbstractNodesGroup<?> cluster) {
        if (beforeClusterInit != null) {
            beforeClusterInit.accept(cluster);
        }
    }

    public AbstractNodesGroupConfig<?> createConfig(String type) {
        Assert.notNull(type, "type is null");
        AbstractNodesGroupConfig<?> config;
        switch (type) {
            case NodesGroupConfig.TYPE_SWARM: {
                SwarmNodesGroupConfig local;
                local = new SwarmNodesGroupConfig();
                config = local;
                break;
            }
            case NodesGroupConfig.TYPE_DOCKER: {
                config = new DockerClusterConfig();
                break;
            }
            default:
                throw new IllegalArgumentException("Unsupported type of cluster: " + type);
        }
        factory.initDefaultConfig((DockerBasedClusterConfig) config);
        config.setName(getCluster());
        return config;
    }
}
