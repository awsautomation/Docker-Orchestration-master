
package com.codeabovelab.dm.cluman.cluster.docker.management;

import com.codeabovelab.dm.cluman.cluster.compose.model.ApplicationEvent;
import com.codeabovelab.dm.common.mb.MessageBus;
import com.codeabovelab.dm.common.mb.MessageBuses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DockerEventConfig {

    @Bean(name = DockerServiceEvent.BUS)
    public MessageBus<DockerServiceEvent> dockerMessageBus() {
        return MessageBuses.create(DockerServiceEvent.BUS, DockerServiceEvent.class);
    }


    @Bean(name = ApplicationEvent.BUS)
    public MessageBus<ApplicationEvent> applicationMessageBus() {
        return MessageBuses.create(ApplicationEvent.BUS, ApplicationEvent.class);
    }
}
