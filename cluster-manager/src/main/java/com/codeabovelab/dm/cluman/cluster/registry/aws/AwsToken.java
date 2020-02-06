
package com.codeabovelab.dm.cluman.cluster.registry.aws;

import com.codeabovelab.dm.cluman.cluster.registry.model.RegistryCredentials;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Builder
@Data
class AwsToken implements RegistryCredentials {
    private final String username;
    private final String password;
    private final Date expiresAt;
    private final String proxyEndpoint;

}
