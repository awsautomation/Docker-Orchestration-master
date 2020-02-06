

package com.codeabovelab.dm.common.meter;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * an object which generated at limit excess
 */
public class LimitExcess {

    public static class Builder {
        private String message;
        public String metric;

        public String getMessage() {
            return message;
        }

        public Builder message(String message) {
            setMessage(message);
            return this;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMetric() {
            return metric;
        }

        public Builder metric(String metric) {
            setMetric(metric);
            return this;
        }

        public void setMetric(String metric) {
            this.metric = metric;
        }

        public LimitExcess build() {
            return new LimitExcess(this);
        }
    }

    private final String metric;
    private final String message;

    @JsonCreator
    public LimitExcess(Builder b) {
        this.message = b.message;
        this.metric = b.metric;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getMessage() {
        return message;
    }

    public String getMetric() {
        return metric;
    }

    @Override
    public String toString() {
        return "LimitExcess{" +
          "metric='" + metric + '\'' +
          ", message='" + message + '\'' +
          '}';
    }
}
