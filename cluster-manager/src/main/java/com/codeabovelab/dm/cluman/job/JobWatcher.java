
package com.codeabovelab.dm.cluman.job;

/**
 * A object which watch for job execution (error, time) and can cancel job on some condition.
 */
public interface JobWatcher {
    /**
     * Synchronously called on job event.
     * @param instance
     * @param event
     */
    void onEvent(JobInstance instance, JobEvent event);
}
