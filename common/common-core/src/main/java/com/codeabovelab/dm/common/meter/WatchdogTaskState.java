

package com.codeabovelab.dm.common.meter;

import java.util.List;

/**
 * immutable state of watchdog task
 */
public final class WatchdogTaskState {
    private final String metricId;
    private final long checkTime;
    private final List<LimitExcess> excesses;

    /**
     * state can be created only by watchdogtask
     * @param metricId
     * @param checkTime
     * @param excesses
     */
    WatchdogTaskState(String metricId, long checkTime, List<LimitExcess> excesses) {
        this.metricId = metricId;
        this.checkTime = checkTime;
        this.excesses = excesses;
    }

    /**
     * id of metric (also watchdog task)
     * @return
     */
    public String getMetricId() {
        return metricId;
    }

    /**
     * Time of state creation, state wil be created immediately after limits checking.
     * @return
     */
    public long getCheckTime() {
        return checkTime;
    }

    /**
     * List of exceeded limits. List may be empty, but non null.
     * @return
     */
    public List<LimitExcess> getExcesses() {
        return excesses;
    }
}
