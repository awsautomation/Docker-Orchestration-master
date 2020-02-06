
package com.codeabovelab.dm.cluman.cluster.registry.model;


import com.codeabovelab.dm.cluman.cluster.registry.RegistryType;
import com.codeabovelab.dm.common.kv.mapping.KvMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * Configuration for registry service
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PrivateRegistryConfig extends DockerRegistryConfig implements RegistryCredentials {

    @NotNull
    @KvMapping
    private String url;

    {
        setRegistryType(RegistryType.PRIVATE);
    }

    @Override
    public PrivateRegistryConfig clone() {
        return (PrivateRegistryConfig) super.clone();
    }
}
