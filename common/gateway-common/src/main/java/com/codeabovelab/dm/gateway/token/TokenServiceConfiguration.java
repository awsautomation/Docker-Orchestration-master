
package com.codeabovelab.dm.gateway.token;

import com.codeabovelab.dm.common.security.token.SignedTokenServiceBackend;
import com.codeabovelab.dm.common.security.token.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;

@Configuration
public class TokenServiceConfiguration {

    @Value("${token.serverSecret:3153620caaf300c37b345d0c2e8dc3aa322c6d9d}")
    private String serverSecret;

    @Value("${token.macAlgorithm:HmacSHA1}")
    private String macAlgorithm;

    @Bean
    TokenService tokenServiceBackend() {
        SignedTokenServiceBackend backend = new SignedTokenServiceBackend();
        backend.setSecureRandom(new SecureRandom());
        backend.setServerSecret(serverSecret);
        backend.setServerInteger(13);
        return backend;
    }
}
