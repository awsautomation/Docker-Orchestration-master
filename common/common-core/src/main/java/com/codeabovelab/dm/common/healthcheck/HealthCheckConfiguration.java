

package com.codeabovelab.dm.common.healthcheck;

import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.health.jvm.ThreadDeadlockHealthCheck;
import com.codeabovelab.dm.common.meter.MeterConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Configuration which defines list of additional metrics for calculating health status
 */
@Configuration
@Import(MeterConfiguration.class)
public class HealthCheckConfiguration {

    @Autowired
    public void setHealthCheckRegistry(HealthCheckRegistry registry) {
        registry.register(ThreadDeadlockHealthCheck.class.getName(), new ThreadDeadlockHealthCheck());
    }

}
