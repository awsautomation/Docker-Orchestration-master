
package com.codeabovelab.dm.cluman.job;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.*;
import org.springframework.stereotype.Component;

/**
 */
@Component
public class JobScope extends AbstractJobScope {
    public static final String SCOPE_NAME = "dmJobScope";

    @Override
    ScopeBeans getContextOrNull() {
        return getBeans();
    }

    static ScopeBeans getBeans() {
        return JobContext.getCurrent().getScopeBeans();
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope(SCOPE_NAME, this);
    }
}
