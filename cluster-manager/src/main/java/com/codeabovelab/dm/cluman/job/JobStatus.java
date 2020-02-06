
package com.codeabovelab.dm.cluman.job;

/**
 */
public enum JobStatus {
    CREATED(false),
    SCHEDULING(false),
    SCHEDULED(false),
    STARTING(false),
    STARTED(false),
    FAILED_STEP(false),
    FAILED_JOB(true),
    COMPLETED(true),
    CANCELLED(true);

    private final boolean end;

    JobStatus(boolean end) {
        this.end = end;
    }

    public boolean isEnd() {
        return end;
    }
}
