
package com.codeabovelab.dm.agent.security;

import lombok.Builder;
import lombok.Data;

import java.io.File;


@Data
@Builder(builderClassName = "Builder")
class KeystoreConfig {
    private final File keystore;
    private final String keystorePassword;
    private final String keyPassword;
}
