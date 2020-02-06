
package com.codeabovelab.dm.cluman.cluster.registry;

import com.codeabovelab.dm.cluman.cluster.registry.model.*;
import org.springframework.web.client.RestTemplate;

abstract class DockerRegistryAdapter<T extends DockerRegistryConfig> implements RegistryAdapter {

    protected final T config;
    private final RestTemplate rt;

    public DockerRegistryAdapter(T config, RestTemplateFactory rtf) {
        this.config = config;
        this.rt = rtf.create(new DockerRegistryAuthAdapter(this::getCredentials));
    }

    @Override
    public RestTemplate getRestTemplate() {
        return rt;
    }

    @Override
    public T getConfig() {
        return config;
    }

    @Override
    public RegistryCredentials getCredentials() {
        return config;
    }
}
