/*
 * Copyright 2016 Code Above Lab LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codeabovelab.dm.mail.configuration;

import com.codeabovelab.dm.mail.template.MailTemplateProvider;
import com.codeabovelab.dm.mail.template.ResourceMailTemplateProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.MimeTypeUtils;

/**
 */
@Configuration
@ComponentScan(basePackageClasses = MailTemplateProvider.class)
public class MailTemplateConfiguration {

    @Bean
    ResourceMailTemplateProvider resourceMailTemplateProvider(ObjectMapper objectMapper) {
        return new ResourceMailTemplateProvider(new ResourceMailTemplateProvider.Config()
          .mimeType(MimeTypeUtils.TEXT_HTML)
          .suffix(".spel"),
          objectMapper
        );
    }
}
