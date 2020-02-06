

package com.codeabovelab.dm.common.healthcheck;

/**
 * Contract for DTO of heath check data entry
 * It can be healthy (with an optional message)
 * or unhealthy (with either an error message or a thrown exception).
 */
public interface HealthCheckResultData {

    /**
     * Id fo health data entry
     * @return id
     */
    String getId();

    /**
     * Additional message
     * @return message
     */
    String getMessage();

    /**
     * an exception thrown during the health check
     * @return an exception thrown during the health check
     */
    String getThrowable();

    /**
     * True value means healthy
     * @return healthy status
     */
    boolean isHealthy();
}
