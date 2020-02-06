

package com.codeabovelab.dm.cluman.mail;

import com.codeabovelab.dm.mail.configuration.MailServiceConfiguration;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableConfigurationProperties(MailConfiguration.MailProperties.class)
@Import(MailServiceConfiguration.class)
@ComponentScan(basePackageClasses = MailNotificationsService.class)
public class MailConfiguration {

    @Data
    @ConfigurationProperties("dm.mail")
    public static class MailProperties {
        private String from;
    }
}
