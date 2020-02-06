
package com.codeabovelab.dm.cluman.job;

/**
 * A "handle" which can trigger job rollback. <p/>
 * Note that this implementations must support serialization to json.
 * @see #rollbackParams(String)
 * @see RollbackJobBean
 */
public interface RollbackHandle {

    /**
     * Type of rollback job
     * @see #rollbackParams(String)
     */
    String ROLLBACK_JOB = "job.rollback";

    /**
     * Execute rollback in specified jobContext.
     */
    void rollback(RollbackContext context);

    /**
     * Make params object for run rollback job.
     * @param id
     * @return
     */
    static JobParameters.Builder rollbackParams(String id) {
        return JobParameters.builder()
          .type(RollbackHandle.ROLLBACK_JOB)
          .title("Rollback job: " + id)
          .parameter("jobId", id);
    }
}
