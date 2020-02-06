

package com.codeabovelab.dm.cluman.yaml;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

/**
 */
public class MappingYamlHttpMessageConverter extends AbstractJackson2HttpMessageConverter {
    public MappingYamlHttpMessageConverter(YAMLMapper objectMapper) {
        super(objectMapper, YamlUtils.MIME_TYPE);
    }
}
