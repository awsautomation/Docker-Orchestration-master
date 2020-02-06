

package com.codeabovelab.dm.cluman.pipeline;

import com.codeabovelab.dm.common.mb.MessageBus;
import com.codeabovelab.dm.common.mb.MessageBuses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = PipelineService.class)
public class PipelineConfiguration {

    @Bean(name = PipelineEvent.BUS)
    MessageBus<PipelineEvent> nodeMessageBus() {
        return MessageBuses.create(PipelineEvent.BUS, PipelineEvent.class);
    }

}
