
package com.codeabovelab.dm.cluman.ui.health;

import com.codeabovelab.dm.cluman.cluster.docker.management.DockerUtils;
import com.codeabovelab.dm.cluman.cluster.docker.model.ContainerDetails;
import com.codeabovelab.dm.cluman.model.DiscoveryStorage;
import com.codeabovelab.dm.common.healthcheck.ServiceHealthCheckResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.function.Consumer;

/**
 * Service which doe health check of container.
 */
@Component
public class HealthCheckService {

    private final DiscoveryStorage discoveryStorage;


    @Autowired
    public HealthCheckService(DiscoveryStorage discoveryStorage) {
        this.discoveryStorage = discoveryStorage;
    }

    public void checkAll(Consumer<ServiceHealthCheckResult> callback) {
        //TODO we need to implement some hatcheck here
        throw new UnsupportedOperationException("we need to implement some hatcheck here");
    }

    /**
     * Check single container health, may return null.
     * @param id
     * @param timeout
     * @return null or ServiceHealthCheckResult
     * @throws InterruptedException
     */
    public ServiceHealthCheckResult checkContainer(String cluster, String id, long timeout) {
        Assert.hasText(id, "id is null or empty");
        ContainerDetails container = discoveryStorage.getService(cluster).getContainer(id);
        if(container == null) {
            throw new RuntimeException("No containers with id: " + id);
        }
        final String hostname = DockerUtils.getFullHostName(container.getConfig());
        Assert.hasText(hostname, "container.config.hostname is null or empty, it strange");
        throw new UnsupportedOperationException("we need to implement some hatcheck here");
    }
}
