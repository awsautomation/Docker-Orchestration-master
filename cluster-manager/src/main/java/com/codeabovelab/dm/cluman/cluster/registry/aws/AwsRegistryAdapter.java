

package com.codeabovelab.dm.cluman.cluster.registry.aws;

import com.codeabovelab.dm.cluman.cluster.registry.model.RegistryAdapter;
import com.codeabovelab.dm.cluman.cluster.registry.model.RegistryCredentials;
import com.codeabovelab.dm.cluman.cluster.registry.model.RegistryConfig;
import com.codeabovelab.dm.cluman.cluster.registry.model.RestTemplateFactory;
import org.springframework.web.client.RestTemplate;

public class AwsRegistryAdapter implements RegistryAdapter {

    private final AwsToken awsToken;
    private final AwsRegistryConfig config;
    private final RestTemplate rt;

    public AwsRegistryAdapter(AwsService awsService, AwsRegistryConfig config, RestTemplateFactory rtf) {
        this.config = config;
        this.awsToken = awsService.fetchToken(config);
        String name = config.getName();
        if(name == null) {
           config.setName(awsToken.getProxyEndpoint());
        }
        this.rt = rtf.create(new AwsRegistryAuthAdapter(this));
    }

    @Override
    public RestTemplate getRestTemplate() {
        return rt;
    }

    @Override
    public String getUrl() {
        return awsToken.getProxyEndpoint();
    }

    @Override
    public RegistryConfig getConfig() {
        return config;
    }

    @Override
    public RegistryCredentials getCredentials() {
        return awsToken;
    }
}
