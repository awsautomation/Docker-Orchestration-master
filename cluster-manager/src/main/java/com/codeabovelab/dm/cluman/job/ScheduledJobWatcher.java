
package com.codeabovelab.dm.cluman.job;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * You must create watcher for each
 */
public class ScheduledJobWatcher implements JobWatcher {

    public static final int MAX_ERRORS = 10;
    private final int maxErrors;
    private final AtomicInteger errors = new AtomicInteger();

    public ScheduledJobWatcher() {
        this.maxErrors = MAX_ERRORS;
    }

    @Override
    public void onEvent(JobInstance instance, JobEvent event) {
        Throwable ex = event.getException();
        if(ex != null) {
            int count = errors.incrementAndGet();
            if(count >= maxErrors) {
                instance.cancel();
            }
        }
    }
}
