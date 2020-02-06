

package com.codeabovelab.dm.cluman.cluster.registry.aws;

import com.codeabovelab.dm.cluman.cluster.registry.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class AwsRegistryFactoryAdapter implements RegistryFactoryAdapter<AwsRegistryConfig> {

    private final AwsService awsService;

    @Override
    public RegistryService create(RegistryFactory factory, AwsRegistryConfig config) {
        return RegistryServiceImpl.builder()
          .adapter(new AwsRegistryAdapter(awsService, config, factory::restTemplate))
          .searchConfig(factory.getSearchIndexDefaultConfig())
          .build();
    }

    @Override
    public void complete(AwsRegistryConfig config) {
        if (config.getName() != null) {
            return;
        }
        AwsToken token = awsService.fetchToken(config);
        String endpoint = token.getProxyEndpoint();
        config.setName(RegistryUtils.getNameByUrl(endpoint));
    }
}
