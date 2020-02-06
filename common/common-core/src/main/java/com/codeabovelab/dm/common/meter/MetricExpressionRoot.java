

package com.codeabovelab.dm.common.meter;

import com.codahale.metrics.*;

/**
 * root of metric expression
 */
class MetricExpressionRoot {
    private final Metric metric;

    MetricExpressionRoot(Metric metric) {
        this.metric = metric;
    }

    public Metric getMetric() {
        return this.metric;
    }

    public Timer getTimer() {
        return getIfInstance(Timer.class);
    }

    public Meter getMeter() {
        return getIfInstance(Meter.class);
    }

    public Counter getCounter() {
        return getIfInstance(Counter.class);
    }

    public Histogram getHistogram() {
        return getIfInstance(Histogram.class);
    }

    private <T> T getIfInstance(Class<T> type) {
        if(type.isInstance(this.metric)) {
            return type.cast(this.metric);
        }
        return null;
    }
}
