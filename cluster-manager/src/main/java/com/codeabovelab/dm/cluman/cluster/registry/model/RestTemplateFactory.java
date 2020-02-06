
package com.codeabovelab.dm.cluman.cluster.registry.model;

import org.springframework.web.client.RestTemplate;

public interface RestTemplateFactory {
    RestTemplate create(RegistryAuthAdapter raa);
}
