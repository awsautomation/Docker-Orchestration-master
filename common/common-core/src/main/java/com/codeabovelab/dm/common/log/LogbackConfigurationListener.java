

package com.codeabovelab.dm.common.log;

import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.ContextBase;
import ch.qos.logback.core.joran.spi.JoranException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;

/**
 *
 *  LogbackConfigurationListener checks 'logging.config.src' property after refreshing context
 *  and invokes reconfiguring logback
 *
 */
@Component
@AllArgsConstructor
public class LogbackConfigurationListener implements ApplicationListener<ApplicationEvent> {

    private final Environment environment;

    private static final Logger LOG = LoggerFactory.getLogger(LogbackConfigurationListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        final String settings = environment.getProperty("logging.config.src");
        if (StringUtils.hasText(settings)) {
            try {
                final ContextBase context = (ContextBase) StaticLoggerBinder.getSingleton().getLoggerFactory();
                final JoranConfigurator configurator = new JoranConfigurator();
                configurator.setContext(context);
                LOG.info("try to update logback configuration to {}", settings);
                context.reset();
                configurator.doConfigure(new ByteArrayInputStream(settings.getBytes()));
            } catch (JoranException e) {
                LOG.error("can't load settings", e);
            }
        }
    }
}
