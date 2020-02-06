
package com.codeabovelab.dm.cluman.cluster.registry.aws;

import com.codeabovelab.dm.cluman.cluster.registry.RegistryType;
import com.codeabovelab.dm.cluman.cluster.registry.model.RegistryConfig;
import com.codeabovelab.dm.common.kv.mapping.KvMapping;
import com.codeabovelab.dm.common.kv.mapping.PropertyCipher;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Configuration for registry service
 */
@EqualsAndHashCode(callSuper = true)
@Data
public final class AwsRegistryConfig extends RegistryConfig {
    @KvMapping
    private String accessKey;
    @KvMapping(interceptors = PropertyCipher.class)
    private String secretKey;
    @KvMapping
    private String region;
    {
        setRegistryType(RegistryType.AWS);
    }

    @Override
    public AwsRegistryConfig clone() {
        return (AwsRegistryConfig) super.clone();
    }

    @Override
    public void cleanCredentials() {
        setSecretKey(null);
    }
}
