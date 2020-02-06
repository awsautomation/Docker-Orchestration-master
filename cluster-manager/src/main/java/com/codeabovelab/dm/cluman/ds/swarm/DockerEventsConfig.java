

package com.codeabovelab.dm.cluman.ds.swarm;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("dm.docker.events.configuration")
public class DockerEventsConfig {

    private int countOfThreads = 2;
    private int periodInSeconds = 90;
    private int initialDelayInSeconds = 10;

}
