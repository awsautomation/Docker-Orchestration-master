
package com.codeabovelab.dm.cluman.job;

/**
 * @see JobEventCriteriaImpl
 */
public interface JobEventCriteria {
    /**
     * Id of job
     * @return
     */
    String getId();

    /**
     * Type of job
     * @return
     */
    String getType();
}
