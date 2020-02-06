
package com.codeabovelab.dm.cluman.job;

import java.util.Set;

/**
 */
public interface JobFactory {
    /**
     * Create job instance, but not run it. For list of parameters see {@link JobDescription }
     * @param parameters
     * @return
     */
    JobInstance create(JobParameters parameters);

    /**
     * Job parameters description.
     * @param jobType
     * @return
     */
    JobDescription getDescription(String jobType);

    /**
     * Set of known job types.
     * @return
     */
    Set<String> getTypes();
}
