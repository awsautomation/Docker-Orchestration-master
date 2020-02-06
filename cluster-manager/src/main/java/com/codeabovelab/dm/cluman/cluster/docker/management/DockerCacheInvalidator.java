
package com.codeabovelab.dm.cluman.cluster.docker.management;

import com.codeabovelab.dm.cluman.model.ContainerBase;
import com.codeabovelab.dm.cluman.model.DockerLogEvent;
import com.codeabovelab.dm.common.cache.CacheInvalidator;
import com.codeabovelab.dm.common.mb.MessageBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

@Component
class DockerCacheInvalidator implements CacheInvalidator {

    private final Map<String, Consumer<DockerLogEvent>> listeners = new ConcurrentHashMap<>();

    @Autowired
    @Qualifier(DockerLogEvent.BUS)
    private MessageBus<DockerLogEvent> logEvents;

    @SuppressWarnings("unchecked")
    @Override
    public void init(Cache cache, Map<String, String> args) {
        String name = cache.getName();
        if(!DockerService.CACHE_CONTAINER_DETAILS.equals(name)) {
            return;
        }
        Consumer<DockerLogEvent> listener = this.listeners.computeIfAbsent(name, (n) -> this.makeInvalidator(cache));
        logEvents.subscribe(listener);
    }

    private Consumer<DockerLogEvent> makeInvalidator(Cache cache) {
        return (e) -> {
            ContainerBase container = e.getContainer();
            String name = container.getName();
            String id = container.getId();
            if(name != null && id != null) {
                cache.evict(name);
                cache.evict(id);
                // docker also can return containers by its 12 symbols id
                cache.evict(id.substring(0, 12));
            }
        };
    }

    @PreDestroy
    void preDestroy() {
        listeners.values().forEach((l) -> this.logEvents.asSubscriptions().unsubscribe(l));
    }
}
