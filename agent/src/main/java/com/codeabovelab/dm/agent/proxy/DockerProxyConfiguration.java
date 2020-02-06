
package com.codeabovelab.dm.agent.proxy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

@ComponentScan(basePackageClasses = DockerProxyConfiguration.class)
@Configuration
public class DockerProxyConfiguration {

    @Bean
    public Servlet dispatcherServlet() {
        return new ProxyServlet();
    }
}
