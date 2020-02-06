
package com.codeabovelab.dm.cluman.cluster.registry;

import com.codeabovelab.dm.cluman.cluster.registry.aws.AwsRegistryConfig;
import com.codeabovelab.dm.cluman.cluster.registry.model.HubRegistryConfig;
import com.codeabovelab.dm.cluman.cluster.registry.model.PrivateRegistryConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties("dm.registries")
@Data
public class RegistriesProperties {
    /**
     * Used for synchronous initialization of registries.
     * <p/> Usually applicable for debugging and tests.
     */
    private boolean syncInit = false;

    private List<PrivateRegistryConfig> privateRegistry;
    private List<HubRegistryConfig> hubRegistry;
    private List<AwsRegistryConfig> awsRegistry;
}
