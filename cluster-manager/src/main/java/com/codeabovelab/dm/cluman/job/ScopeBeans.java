
package com.codeabovelab.dm.cluman.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Beans for scope
 */
@Slf4j
class ScopeBeans {
    private final Map<String, Object> beans = new HashMap<>();
    private final ConcurrentMap<String, Set<Runnable>> callbacks = new ConcurrentHashMap<>();
    final JobContext context;
    final String id;

    protected ScopeBeans(JobContext context, String id) {
        this.context = context;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    void registerDestructionCallback(String name, Runnable callback) {
        callbacks.computeIfAbsent(name, (n) -> Collections.synchronizedSet(new HashSet<>())).add(callback);
    }

    void close() {
        try {
            for (Map.Entry<String, Set<Runnable>> entry : callbacks.entrySet()) {
                String key = entry.getKey();
                for (Runnable runnable : entry.getValue()) {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        log.error("On bean {} callback: {}", key, runnable, e);
                    }
                }
            }
        } catch (Exception e) {
            log.error("On close ", e);
        } finally {
            callbacks.clear();
        }
        //we clear beans but not attributes, because it can be need on next iteration
        synchronized (beans) {
            beans.clear();
        }
    }

    Object removeBean(String name) {
        synchronized (this.beans) {
            return this.beans.remove(name);
        }
    }


    Object getBean(String name, ObjectFactory<?> objectFactory) {
        // we cannot use computeIfAbsent because it does not support recursion
        Object bean;
        synchronized (this.beans) {
            bean = this.beans.computeIfAbsent(name, k -> objectFactory.getObject());
        }
        return bean;
    }

    void putBean(String name, Object bean) {
        synchronized (this.beans) {
            Object old = this.beans.putIfAbsent(name, bean);
            Assert.isNull(old, "Can not rewrite bean: old=" + old + " new=" + bean + "  name=" + name);
        }
    }
}
