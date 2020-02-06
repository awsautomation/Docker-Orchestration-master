
package com.codeabovelab.dm.cluman.reconfig;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 */
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class ReConfigurableBeanPostProcessor implements BeanPostProcessor {

    private final AppConfigService configService;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> type = bean.getClass();
        ReConfigurable ann = AnnotationUtils.findAnnotation(type, ReConfigurable.class);
        if(ann == null) {
            return bean;
        }
        configService.registerIfAbsent(beanName, () -> new ReConfigurableBeanAdapter(beanName, bean));
        return bean;
    }
}
