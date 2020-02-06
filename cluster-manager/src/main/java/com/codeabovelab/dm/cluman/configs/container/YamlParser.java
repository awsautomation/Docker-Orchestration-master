
package com.codeabovelab.dm.cluman.configs.container;

import com.codeabovelab.dm.cluman.model.ContainerSource;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Parser for yaml configs
 */
@Component
@Slf4j
public class YamlParser extends AbstractParser {

    private final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

    @Override
    public void parse(String fileName, ContainerCreationContext context) {
        parse(fileName, context, ".yml");
    }

    @Override
    public void parse(File file, ContainerCreationContext context) {
        try {
            ContainerSource configuration = mapper.readValue(file, ContainerSource.class);
            List<String> include = configuration.getInclude();
            include.forEach(a -> parse(new File(file.getParent(), a), context));
            context.addCreateContainerArg(configuration);
        } catch (IOException e) {
            log.error("can't parse configuration", e);
        }
    }

    @Override
    public void parse(Map<String, Object> map, ContainerCreationContext context) {
    }

    @Override
    public void parse(Map<String, Object> map, ContainerSource arg) {
    }

}
