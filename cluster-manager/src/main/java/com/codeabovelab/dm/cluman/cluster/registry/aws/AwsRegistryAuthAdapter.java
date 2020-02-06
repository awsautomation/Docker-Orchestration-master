

package com.codeabovelab.dm.cluman.cluster.registry.aws;

import com.codeabovelab.dm.cluman.cluster.registry.model.RegistryAuthAdapter;

import java.util.Base64;


class AwsRegistryAuthAdapter implements RegistryAuthAdapter {

    private final AwsRegistryAdapter registryAdapter;

    public AwsRegistryAuthAdapter(AwsRegistryAdapter registryAdapter) {
        this.registryAdapter = registryAdapter;
    }

    @Override
    public void handle(AuthContext ctx) {
        ctx.getRequestHeaders().add("Authorization", "Basic " + Base64.getEncoder()
          .encodeToString(("AWS:" + registryAdapter.getCredentials().getPassword()).getBytes()));
    }
}
