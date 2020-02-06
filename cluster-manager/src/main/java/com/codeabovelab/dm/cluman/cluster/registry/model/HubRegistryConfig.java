
package com.codeabovelab.dm.cluman.cluster.registry.model;

import com.codeabovelab.dm.cluman.cluster.registry.RegistryType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Configuration for registry service
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HubRegistryConfig extends DockerRegistryConfig implements RegistryCredentials {

    {
        setRegistryType(RegistryType.DOCKER_HUB);
    }

    @Override
    public HubRegistryConfig clone() {
        return (HubRegistryConfig) super.clone();
    }
}
