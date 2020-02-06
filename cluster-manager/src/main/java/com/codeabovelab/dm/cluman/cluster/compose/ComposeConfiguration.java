

package com.codeabovelab.dm.cluman.cluster.compose;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComposeConfiguration {

    @Value("${dm.compose.monitor.check.interval.sec:2}")
    private int checkInterval;

    @Value("${dm.compose.files.location}")
    private String baseDir;

    @Bean
    ComposeExecutor composeExecutor() {
        return ComposeExecutor.builder()
                .basedir(baseDir)
                .checkIntervalInSec(checkInterval)
                .build();
    }
}
