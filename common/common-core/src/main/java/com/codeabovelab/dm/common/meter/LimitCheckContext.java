

package com.codeabovelab.dm.common.meter;

import com.codahale.metrics.Metric;

/**
 * context of limit check
 */
public final class LimitCheckContext {
    private final Metric metric;
    private final String metricId;

    public LimitCheckContext(Metric metric, String metricId) {
        this.metric = metric;
        this.metricId = metricId;
    }

    public Metric getMetric() {
        return metric;
    }

    public String getMetricId() {
        return metricId;
    }
}
