
package com.codeabovelab.dm.cluman.configs.container;

import com.codeabovelab.dm.cluman.model.ContainerSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.bind.PropertiesConfigurationFactory;
import org.springframework.boot.env.PropertySourcesLoader;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Map;

@Component
@Slf4j
public class DefaultParser extends AbstractParser {

    private final DefaultConversionService defaultConversionService = new DefaultConversionService();

    @Override
    public void parse(String fileName, ContainerCreationContext context) {
        parse(fileName, context, ".properties");
        parse(fileName, context, ".yml");

    }

    @Override
    public void parse(File file, ContainerCreationContext context) {
        try {
            ContainerSource arg = new ContainerSource();
            PropertySourcesLoader loader = new PropertySourcesLoader();
            loader.load(new FileSystemResource(file));
            MutablePropertySources loaded = loader.getPropertySources();
            PropertiesConfigurationFactory<Object> factory = new PropertiesConfigurationFactory<>(arg);

            factory.setPropertySources(loaded);
            factory.setConversionService(defaultConversionService);
            factory.bindPropertiesToTarget();
            arg.getInclude().forEach(a -> parse(new File(file.getParent(), a), context));
            context.addCreateContainerArg(arg);
        } catch (Exception e) {
            log.error("can't parse configuration", e.getMessage());
        }
    }

    @Override
    public void parse(Map<String, Object> map, ContainerCreationContext context) {

        ContainerSource arg = new ContainerSource();
        context.addCreateContainerArg(arg);
        parse(map, arg);

    }

    @Override
    public void parse(Map<String, Object> map, ContainerSource arg) {
        try {
            PropertiesConfigurationFactory<Object> factory = new PropertiesConfigurationFactory<>(arg);

            MutablePropertySources propertySources = new MutablePropertySources();
            PropertySource propertySource = new MapPropertySource("inner", map);
            propertySources.addFirst(propertySource);
            factory.setPropertySources(propertySources);
            factory.setConversionService(defaultConversionService);
            factory.bindPropertiesToTarget();
            log.debug("result of parsing msp {}", arg);
        } catch (Exception e) {
            log.error("", e);
        }

    }


    protected void parse(String fileName, ContainerCreationContext context, String extension) {
        File initialFile = new File(fileName + extension);
        log.info("checking for existing file {}", initialFile);
        if (initialFile.exists()) {
            log.info("ok. parsing file {}", initialFile);
            parse(initialFile, context);
        }
    }

}
