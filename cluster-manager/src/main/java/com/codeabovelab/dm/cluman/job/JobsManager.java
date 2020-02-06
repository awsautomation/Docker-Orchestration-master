
package com.codeabovelab.dm.cluman.job;

import com.codeabovelab.dm.common.mb.ConditionalSubscriptions;

import java.util.Collection;

/**
 */
public interface JobsManager extends JobFactory {

    /**
     * @see JobEventCriteriaImpl
     * @return
     */
    ConditionalSubscriptions<JobEvent, JobEventCriteria> getSubscriptions();

    Collection<JobInstance> getJobs();

    /**
     * Delete job.
     * @param id job instance id
     * @return deleted job instance, or null when it not found.
     */
    JobInstance deleteJob(String id);

    /**
     * Retrieve job by id.
     * @param id
     * @return job instance or null
     */
    JobInstance getJob(String id);
}
