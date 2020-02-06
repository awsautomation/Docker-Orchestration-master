
package com.codeabovelab.dm.common.format;

import com.codeabovelab.dm.common.utils.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.*;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Configuration
@ComponentScan
public class MetatypeFormatterRegistryConfiguration {

    @Autowired(required = false)
    private FormatterRegistry formatterRegistry;

    @Bean
    MetatypeFormatterRegistry metatypeFormatterRegistry() {
        return new DefaultMetatypeFormatterRegistry();
    }

    @Autowired
    @SuppressWarnings("unchecked")
    void configureMetatypeFormatterRegistry(MetatypeFormatterRegistry metatypeFormatterRegistry,
                                            List<Formatter<?>> formatters) {
        for(final Formatter<?> formatter: formatters) {
            Set<Key<?>> set = FormatterUtils.getHandledMetatypes(formatter);
            if(set.isEmpty()) {
                continue;
            }
            final Set<Class<?>> types = new HashSet<>();
            for(Key<?> key: set) {
                types.add(key.getType());
                metatypeFormatterRegistry.addFormatter(key, (Formatter)formatter);
            }
            if(formatterRegistry != null) {
                formatterRegistry.addFormatterForFieldAnnotation(new AnnotationAnnotationFormatterFactory(types, formatter));
            }
        }
    }

    private static class AnnotationAnnotationFormatterFactory implements AnnotationFormatterFactory<Annotation> {
        private final Set<Class<?>> types;
        private final Formatter<?> formatter;

        public AnnotationAnnotationFormatterFactory(Set<Class<?>> types, Formatter<?> formatter) {
            this.types = Collections.unmodifiableSet(types);
            this.formatter = formatter;
        }

        @Override
        public Set<Class<?>> getFieldTypes() {
            return types;
        }

        @Override
        public Printer<?> getPrinter(Annotation annotation, Class<?> fieldType) {
            return formatter;
        }

        @Override
        public Parser<?> getParser(Annotation annotation, Class<?> fieldType) {
            return formatter;
        }
    }
}
