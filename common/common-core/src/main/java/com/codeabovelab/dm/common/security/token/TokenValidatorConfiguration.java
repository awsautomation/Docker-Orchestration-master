

package com.codeabovelab.dm.common.security.token;

import com.codeabovelab.dm.common.cache.CacheConfig;
import com.codeabovelab.dm.common.cache.ConfigurableCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for token validator.
 */
@ConditionalOnBean(TokenService.class)
@Configuration
@ComponentScan
public class TokenValidatorConfiguration {

    @Autowired
    private TokenValidatorSettings tokenValidatorSettings;

    /**
     * Create token validator service. <p/>
     * NOTE that for 'distributedCacheManager' you may need to enable 'redis' profile.
     *
     * @return
     */
    @Bean
    TokenValidator tokenValidator(TokenService tokenService, CacheManager cacheManager) {

        TokenValidatorImpl validator = TokenValidatorImpl.builder()
                //we need to use global redis cache
                .cache(((ConfigurableCacheManager) cacheManager).getCache(CacheConfig.builder()
                        .name("tokenServiceCache")
                        // we hold lastAccess twice as long then needed
                        .expireAfterWrite(tokenValidatorSettings.getExpireAfterInSec() * 1000L * 2)
                        .build()))
                .settings(tokenValidatorSettings)
                .tokenService(tokenService).build();
        return validator;
    }
}
