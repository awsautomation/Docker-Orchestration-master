

package com.codeabovelab.dm.common.healthcheck;

import com.codeabovelab.dm.common.log.ApplicationInfo;

import java.util.List;

/**
 * Health check command result contract
 */
public interface ServiceHealthCheckResult {

    /**
     * see com.codeabovelab.dm.common.log.ApplicationInfo
     * @return ApplicationInfo
     */
    ApplicationInfo getApplicationInfo();

    /**
     * see com.codeabovelab.dm.common.healthcheck.HealthCheckResultData
     * @return list of HealthCheckResultData
     */
    List<HealthCheckResultData> getResults();

    /**
     * health status
     * @return health status
     */
    boolean isHealthy();
}
