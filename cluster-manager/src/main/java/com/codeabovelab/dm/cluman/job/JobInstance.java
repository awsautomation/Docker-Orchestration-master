
package com.codeabovelab.dm.cluman.job;

import com.google.common.util.concurrent.ListenableFuture;

import java.text.MessageFormat;
import java.util.List;

/**
 * Instance of job
 */
public interface JobInstance {

    JobInfo getInfo();

    /**
     * Context of job used internally for parameters and job result.
     * @return
     */
    JobContext getJobContext();

    /**
     * Async cancel job execution, applied in any non end state. On end state return false. Idempotent.
     * @return future with boolean mean that state of job instance changed by this call (true) or by another cause (false).
     */
    ListenableFuture<Boolean> cancel();

    /**
     * Async start job execution. Invoked by {@link JobsManager }. Idempotent.
     * For jobs with schedule, it do schedule of job.
     * @return future with boolean mean that state of job instance changed by this call (true) or by another cause (false).
     */
    ListenableFuture<Boolean> start();

    /**
     * Return future which is called at end of job work. It way to wait job completion.
     * @return
     */
    ListenableFuture<JobInstance> atEnd();

    /**
     * immutable list of job events
     * @return
     */
    List<JobEvent> getLog();

    /**
     * Send message into job log. Message support formatting as {@link MessageFormat#format(String, Object...)}. <p/>
     * First throwable object in args will be removed from its and passed to  event as {@link JobEvent#getException()}.
     * @param message message with
     * @param args objects, also first find throwable will be extracted and passed into event as {@link JobEvent#getException()}
     */
    void send(String message, Object ... args);
}
