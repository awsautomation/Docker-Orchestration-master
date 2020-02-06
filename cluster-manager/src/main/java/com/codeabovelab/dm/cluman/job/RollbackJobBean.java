
package com.codeabovelab.dm.cluman.job;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Rollback any job which is support it.
 * @see RollbackHandle
 */
@JobBean(RollbackHandle.ROLLBACK_JOB)
public class RollbackJobBean implements Runnable {

    /**
     * Id of job which must be rollback
     */
    @JobParam(required = true)
    private String jobId;

    @Autowired
    private JobContext jobContext;

    @Autowired
    private ListableBeanFactory beanFactory;

    @Autowired
    private JobsManager jobsManager;

    @Override
    public void run() {
        JobInstance job = jobsManager.getJob(jobId);
        if(job == null) {
            throw new IllegalArgumentException("Can not find job for jobId:" + jobId);
        }
        JobContext jc = job.getJobContext();
        RollbackHandle rh = jc.getRollback();
        if(rh == null) {
            throw new IllegalArgumentException("Job (" + jobId + ") does not support rollback.");
        }
        RollbackContext rc = new RollbackContext(this.beanFactory, this.jobsManager, this.jobContext);
        rh.rollback(rc);
    }
}
