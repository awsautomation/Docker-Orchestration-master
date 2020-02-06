
package com.codeabovelab.dm.cluman.ds.nodes;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 */
@Data
@Component
@ConfigurationProperties("dm.nodeStorage")
public class NodeStorageConfig {
    /**
     * Maximal value of expected nodes count. <p/>
     * It not limit, it used for allocate some resources, so you can
     * exceed this value, but then performance may degrade.
     */
    private int maxNodes = 12;
    /**
     * Minimal ttl of node in seconds, note that node may not respond on maintenance
     * and we must keep they while this time.
     */
    private int minTtl = 60;
    /**
     * Time between nodes update
     */
    private int updateSeconds = 60;
}
