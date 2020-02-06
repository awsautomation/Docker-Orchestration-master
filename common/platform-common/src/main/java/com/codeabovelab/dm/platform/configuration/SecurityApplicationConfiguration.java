
package com.codeabovelab.dm.platform.configuration;

import com.codeabovelab.dm.common.security.AdminRoleVoter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class SecurityApplicationConfiguration {

    @Value("${dm.bcrypt.strength:8}")
    private Integer bcryptStrength;

    @Bean(name = "annotationValidator")
    public LocalValidatorFactoryBean getLocalValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(bcryptStrength);
    }

    @Bean
    public RoleVoter getRoleVoter() {
        return new AdminRoleVoter();
    }

}
