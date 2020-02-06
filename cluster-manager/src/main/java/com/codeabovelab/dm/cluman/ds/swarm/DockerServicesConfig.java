
package com.codeabovelab.dm.cluman.ds.swarm;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Config for docker services.
 */
@Data
@ConfigurationProperties("dm.dockerServices")
public class DockerServicesConfig {
    private final long cacheTimeout = 60_000;
    private final long refreshInfoSeconds = 10;
}
