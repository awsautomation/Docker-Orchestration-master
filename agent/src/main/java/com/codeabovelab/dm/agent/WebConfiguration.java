
package com.codeabovelab.dm.agent;

import com.codeabovelab.dm.agent.notifier.DataProvider;
import com.codeabovelab.dm.agent.notifier.Notifier;
import com.codeabovelab.dm.agent.security.AuthConfiguration;
import com.codeabovelab.dm.agent.security.SslServletContainerCustomizer;
import com.codeabovelab.dm.common.json.JacksonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@Import({
  SslServletContainerCustomizer.class,
  AuthConfiguration.class,
  EmbeddedServletContainerAutoConfiguration.class,
  WebSocketAutoConfiguration.class,
  WebConfiguration.PreConfiguration.class,
  Notifier.class,
  DataProvider.class
})
@Configuration
public class WebConfiguration {

    /**
     * It need for beans like {@link Notifier}
     */
    @Configuration
    public class PreConfiguration {
        @Bean
        RestTemplate restTemplate() {
            return new RestTemplate();
        }

        @Bean
        ObjectMapper objectMapper() {
            return JacksonUtils.objectMapperBuilder();
        }
    }
}
