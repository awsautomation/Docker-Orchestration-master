
package com.codeabovelab.dm.cluman.events;

import com.codeabovelab.dm.cluman.model.WithSeverity;
import com.codeabovelab.dm.common.mb.Subscriptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventsConfiguration {
    @Bean(name = EventsUtils.BUS_ERRORS)
    Subscriptions<WithSeverity> errorMessageBus(ErrorAggregator errorAggregator) {
        return errorAggregator.getSubscriptions();
    }
}
