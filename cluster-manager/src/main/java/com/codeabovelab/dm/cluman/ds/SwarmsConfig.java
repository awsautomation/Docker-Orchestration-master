
package com.codeabovelab.dm.cluman.ds;

import com.codeabovelab.dm.cluman.cluster.docker.ClusterConfigImpl;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * Entry for multiple swarms configuration
 */
@ConfigurationProperties("dm.swarm")
@Data
public class SwarmsConfig {
    private Map<String, ClusterConfigImpl.Builder> configs;

    private ClusterConfigImpl.Builder defaultConfig;
}
