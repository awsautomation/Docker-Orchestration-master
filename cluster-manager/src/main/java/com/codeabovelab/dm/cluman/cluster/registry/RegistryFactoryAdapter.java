
package com.codeabovelab.dm.cluman.cluster.registry;

import com.codeabovelab.dm.cluman.cluster.registry.model.RegistryConfig;

/**
 */
public interface RegistryFactoryAdapter<T extends RegistryConfig> {
    RegistryService create(RegistryFactory factory, T config);

    /**
     * Fill some config values from other. Operation must be idempotent.
     * @param config
     */
    void complete(T config);
}
