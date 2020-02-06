

package com.codeabovelab.dm.common.meter;

import com.codahale.metrics.*;

import java.util.Map;

/**
 * adapter for specific metric
 */
interface MetricAdapter<T extends Metric> {

    MetricAdapter<Meter> METER = new MetricAdapter<Meter>() {
        @Override
        public Map<String, Meter> getMap(MetricRegistry metricRegistry) {
            return metricRegistry.getMeters();
        }

        @Override
        public Meter getOrCreate(MetricRegistry metricRegistry, String name) {
            return metricRegistry.meter(name);
        }
    };

    MetricAdapter<Counter> COUNTER = new MetricAdapter<Counter>() {
        @Override
        public Map<String, Counter> getMap(MetricRegistry metricRegistry) {
            return metricRegistry.getCounters();
        }

        @Override
        public Counter getOrCreate(MetricRegistry metricRegistry, String name) {
            return metricRegistry.counter(name);
        }
    };

    MetricAdapter<Timer> TIMER = new MetricAdapter<Timer>() {
        @Override
        public Map<String, Timer> getMap(MetricRegistry metricRegistry) {
            return metricRegistry.getTimers();
        }

        @Override
        public Timer getOrCreate(MetricRegistry metricRegistry, String name) {
            return metricRegistry.timer(name);
        }
    };

    Map<String, T> getMap(MetricRegistry metricRegistry);

    T getOrCreate(MetricRegistry metricRegistry, String name);
}
