
package com.codeabovelab.dm.agent.notifier;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("dm.agent.notifier")
public class NotifierProps {
    private String secret;
    private String rootPath;
    private String server;
    private String address;
}
