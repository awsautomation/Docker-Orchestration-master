
package com.codeabovelab.dm.cluman.cluster.registry;

import com.codeabovelab.dm.cluman.cluster.registry.model.PrivateRegistryConfig;
import com.codeabovelab.dm.cluman.cluster.registry.model.RestTemplateFactory;

public class PrivateRegistryAdapter extends DockerRegistryAdapter<PrivateRegistryConfig> {

    public PrivateRegistryAdapter(PrivateRegistryConfig config, RestTemplateFactory rtf) {
        super(config, rtf);
    }

    @Override
    public String getUrl() {
        return config.getUrl();
    }
}
