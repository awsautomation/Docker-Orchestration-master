

package com.codeabovelab.dm.common.log;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.concurrent.SettableListenableFuture;

/**
 * place for log configuration, and also
 * workaround for access tom some spring beans from {@link com.codeabovelab.dm.common.log.AmqpAppender } which does
 * not managed by spring
 */
@Configuration
public class LogConfiguration implements ApplicationContextAware {

    static final SettableListenableFuture<ApplicationContext> DEFERRED_RESULT = new SettableListenableFuture<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DEFERRED_RESULT.set(applicationContext);
    }

}
