

package com.codeabovelab.dm.cluman.job;

import com.codeabovelab.dm.common.utils.SafeCloseable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Scope which is actual for each iteration of job. For simple jobs it equal with {@link JobScope }, differences is
 * appeared only on scheduled jobs with repeatable context.
 */
@Component
public class JobScopeIteration extends AbstractJobScope {
    public static final String SCOPE_NAME = "dmJobScopeIteration";
    private static final ThreadLocal<ScopeBeans> TL = new ThreadLocal<>();

    @Override
    ScopeBeans getContextOrNull() {
        return TL.get();
    }

    static ScopeBeans getBeans() {
        return TL.get();
    }

    public static SafeCloseable open(JobContext jobContext) {
        final ScopeBeans old = TL.get();
        if(old != null) {
            return () -> {};
        }
        ScopeBeans beans = new ScopeBeans(jobContext, jobContext.getId() + "-iter#" + jobContext.getIteration());
        TL.set(beans);
        return TL::remove;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope(SCOPE_NAME, this);
    }

}
