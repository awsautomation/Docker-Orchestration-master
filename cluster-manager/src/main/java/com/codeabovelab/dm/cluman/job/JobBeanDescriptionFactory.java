
package com.codeabovelab.dm.cluman.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 */
@Component
class JobBeanDescriptionFactory {

    private final DefaultListableBeanFactory beanFactory;

    @Autowired
    public JobBeanDescriptionFactory(DefaultListableBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    JobDescription getFor(String jobBeanName) {
        JobDescription.Builder b = JobDescription.builder();
        b.type(jobBeanName);
        Map<String, JobParameterDescription> map = new HashMap<>();
        Set<String> processed = new HashSet<>();

        processBean(processed, map, jobBeanName);

        b.parameters(map);
        return b.build();
    }

    private void processBean(Set<String> processed, Map<String, JobParameterDescription> map, String jobBeanName) {
        Class<?> type = this.beanFactory.getType(jobBeanName);
        if(type == null) {
            return;
        }
        JobBeanIntrospector.Metadata md = JobBeanIntrospector.getMetadata(type);
        if(md == null) {
            //this is not job component
            return;
        }
        processProps(map, md);
        //process dependencies
        // note that beanFactory.getDependenciesForBean(jobBeanName) not work for non singleton beans
        List<JobBeanIntrospector.Dependency> deps = md.getDeps();
        for(JobBeanIntrospector.Dependency dep: deps) {
            String name = dep.getName();
            if(name == null) {
                String[] names = beanFactory.getBeanNamesForType(dep.getType());
                if(names == null || names.length != 1) {
                    //usual mode than one dependency mean error
                    continue;
                }
                name = names[0];
            }
            if(!processed.add(name)) {
                continue;
            }
            processBean(processed, map, name);
        }
    }

    private void processProps(Map<String, JobParameterDescription> map, JobBeanIntrospector.Metadata md) {
        for(JobBeanIntrospector.PropertyMetadata pm : md.getProps().values()) {
            JobParameterDescription pd = new JobParameterDescription(pm.getName(), pm.getType(), pm.isRequired(), pm.isIn(), pm.isOut());
            map.put(pd.getName(), pd);
        }
    }
}
