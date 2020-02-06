
package com.codeabovelab.dm.cluman.ui.configuration;

import com.codeabovelab.dm.cluman.yaml.MappingYamlHttpMessageConverter;
import com.codeabovelab.dm.common.json.JacksonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Main config for ui
 */
@Configuration
public class UiConfiguration {

    /**
     * We use constant for easy find all CORS config
     * @see WebSocketConfiguration
     */
    static final String ALLOWED_ORIGIN = "*";
    private final List<String> exports = Collections.singletonList("/ui/**");

    @Bean
    WebMvcConfigurerAdapter webMvcConfigurerAdapter(YAMLMapper yamlMapper) {
        return new WebMvcConfigurerAdapter() {

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/resources/static/**", "/static/**")
                        .setCacheControl(CacheControl.maxAge(4, TimeUnit.HOURS));
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                MappingYamlHttpMessageConverter mmc = new MappingYamlHttpMessageConverter(yamlMapper);
                converters.add(mmc);
            }

            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                //we need below for @MatrixVariable
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {

                for(String prefix: exports) {
                    CorsRegistration cr = registry.addMapping(prefix);
                    cr.allowedOrigins(ALLOWED_ORIGIN);
                    cr.allowedMethods(HttpMethod.GET.name(),
                      HttpMethod.HEAD.name(),
                      HttpMethod.POST.name(),
                      HttpMethod.PUT.name(),
                      HttpMethod.DELETE.name(),
                      HttpMethod.PATCH.name(),
                      HttpMethod.TRACE.name(),
                      HttpMethod.OPTIONS.name());
                }
            }
        };
    }


    @Bean
    public WelcomePageHandlerMapping welcomePageMapping(@Value("${dm.ui.welcome.paths}") String[] paths) {
        return new WelcomePageHandlerMapping(Arrays.asList(paths));
    }


    @Primary
    @Bean
    public ObjectMapper objectMapper() {
        return JacksonUtils.objectMapperBuilder();
    }

    @Bean
    public YAMLMapper yamlMapper() {
        YAMLMapper mapper = new YAMLMapper();
        JacksonUtils.registerModules(mapper);
        return mapper;
    }
}
