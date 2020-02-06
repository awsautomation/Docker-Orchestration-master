

package com.codeabovelab.dm.common.meter;

import com.codahale.metrics.Metric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * monitor which periodically analyze state of Meters and raise alarm if it's limits exceeded
 */
@Component
public class Watchdog /*TODO implements HealthIndicator*/ {
    private final ConcurrentMap<Metric, WatchdogTask> tasks = new ConcurrentHashMap<>();
    final ScheduledExecutorService scheduledExecutorService;
    private final List<LimitExcessListener> listeners;

    @Autowired
    Watchdog(List<LimitExcessListener> listeners) {
        this.listeners = Collections.unmodifiableList(new ArrayList<>(listeners));
        //we need executor which cannot blocked by unknown task
        // also in health() we need to check for hangs tasks and report it
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new CustomizableThreadFactory("watchdog-"));
    }

    /**
     * register limit on specified metric <p/>
     * currently system support only one limit per metric
     * @param metric
     * @param name name which will be used for identify metric
     */
    public WatchdogTask registerTask(Metric metric, String name) {
        WatchdogTask newTask = new WatchdogTask(this, metric, name);
        WatchdogTask oldTask = tasks.putIfAbsent(metric, newTask);
        if(oldTask != null) {
            newTask = oldTask;
        }
        return newTask;
    }

    /**
     * get already registered watchdog task.
     * @param metric
     * @return task instance if exist, null otherwise
     */
    public WatchdogTask getTask(Metric metric) {
        return tasks.get(metric);
    }

    /**
     * unregister all limits on specified metric
     * @param metric
     */
    public void unregisterTask(Metric metric) {
        WatchdogTask task = tasks.remove(metric);
        task.cancel();
    }

    void fireLimitExcess(LimitExcessEvent event) {
        for(LimitExcessListener limitExcessListener: this.listeners) {
            limitExcessListener.listen(event);
        }
    }
}
