
package com.codeabovelab.dm.cluman.job;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.util.Assert;

import java.util.concurrent.ConcurrentMap;

/**
 * Bean wrapper which create and run specified bean.
 */
class JobBeanTask implements Runnable {

    private final BeanFactory beanFactory;
    private final String beanName;

    public JobBeanTask(BeanFactory beanFactory, String beanName) {
        this.beanFactory = beanFactory;
        this.beanName = beanName;
    }

    @Override
    public void run() {
        Runnable bean = beanFactory.getBean(beanName, Runnable.class);
        bean.run();
        copyOutParameters(bean);
    }

    private void copyOutParameters(Object bean) {
        JobBeanIntrospector.Metadata metadata = JobBeanIntrospector.getMetadata(bean.getClass());
        Assert.notNull(metadata, "Job bean without metadata. How?");
        JobContext ctx = JobContext.getCurrent();
        ConcurrentMap<String, Object> result = ctx.getResult();
        for(JobBeanIntrospector.PropertyMetadata prop: metadata.getProps().values()) {
            if(!prop.isOut()) {
                continue;
            }
            String name = prop.getName();
            Object value = prop.getProperty().get(bean);
            result.put(name, value);
        }
    }
}
