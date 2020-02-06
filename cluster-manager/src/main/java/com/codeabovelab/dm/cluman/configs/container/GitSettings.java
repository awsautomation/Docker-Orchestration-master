

package com.codeabovelab.dm.cluman.configs.container;

import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Data
@Validated
@ConfigurationProperties("dm.image.configuration.git")
public class GitSettings {

    @URL
    private String url;
    private String branch = "master";
    private String username;
    private String password;

}
