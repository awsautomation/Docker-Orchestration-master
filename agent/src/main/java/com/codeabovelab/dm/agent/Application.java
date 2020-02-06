
package com.codeabovelab.dm.agent;

import com.codeabovelab.dm.agent.proxy.DockerProxyConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.security.Security;

@Import({
  PropertySourcesPlaceholderConfigurer.class,
  DockerProxyConfiguration.class,
  WebConfiguration.class
})
@EnableConfigurationProperties(ServerProperties.class)
// do not use @EnableAutoConfiguration
@Configuration
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        new SpringApplicationBuilder(Application.class).run(args);
    }
}
