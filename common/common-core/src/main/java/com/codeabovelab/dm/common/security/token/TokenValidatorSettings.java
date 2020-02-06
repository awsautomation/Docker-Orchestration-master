

package com.codeabovelab.dm.common.security.token;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "dm.token")
public class TokenValidatorSettings {

    /**
     * Timeout in seconds before expiration of token.
     */
    // current value is 24 hours
    private Long expireAfterInSec = 86400L;

    /**
     * Timeout in seconds from last access after which token expires.
     */
    // half hour
    private Long expireLastAccessInSec = 1800L;

}
