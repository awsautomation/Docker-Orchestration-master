
package com.codeabovelab.dm.cluman.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Data location configuration
 */
@Component
@ConfigurationProperties("dm.data")
@Data
public class DataLocationConfiguration {
    private String location;
}
