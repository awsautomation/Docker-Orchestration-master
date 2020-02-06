

package com.codeabovelab.dm.cluman.ui.configuration;

import com.codeabovelab.dm.common.utils.AppInfo;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.ServletContext;
import java.util.Date;

@Configuration
public class SwaggerConfiguration {

    @Autowired
    private ServletContext servletContext;

    @Bean
    public Docket newsApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        return docket
                .groupName("DockMaster")
                .apiInfo(apiInfo())
                //it need for correct samples of date
                .directModelSubstitute(Date.class, Long.class)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(makePathRegexp())
                .build();
    }

    private Predicate<String> makePathRegexp() {
        return Predicates.not(PathSelectors.regex("/error"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Docker Orchestration Endpoint API")
                //.description(" ")
                //.contact(new Contact(", " ,"))
                //.license("Apache License")
                //.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                //.version("1.0, server version: " + AppInfo.getApplicationVersion() + ", revision: " + AppInfo.getBuildRevision())
                .build();
    }


}
