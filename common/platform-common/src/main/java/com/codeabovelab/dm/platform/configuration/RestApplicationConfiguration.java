
package com.codeabovelab.dm.platform.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Provides the REST template for creating REST-based web services
 */
@Configuration
public class RestApplicationConfiguration {

    @Value("${dm.rest-template.connect.to:2000}")
    private Integer connectTimeOut;

    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(connectTimeOut);
        return new RestTemplate(requestFactory);
    }
}
