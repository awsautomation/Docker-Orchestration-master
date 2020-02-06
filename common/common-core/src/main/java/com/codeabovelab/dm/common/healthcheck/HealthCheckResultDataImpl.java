

package com.codeabovelab.dm.common.healthcheck;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Base implementation of com.codeabovelab.dm.common.healthcheck.HealthCheckResultData
 * see com.codeabovelab.dm.common.healthcheck.HealthCheckResultData
 */
public class HealthCheckResultDataImpl implements HealthCheckResultData {

    public static class Builder implements HealthCheckResultData {
        private String id;
        private String message;
        private String throwable;
        private boolean healthy;

        @Override
        public String getId() {
            return id;
        }

        public Builder id(String id) {
            setId(id);
            return this;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
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

        @Override
        public String getThrowable() {
            return throwable;
        }

        public Builder throwable(String throwable) {
            setThrowable(throwable);
            return this;
        }

        public void setThrowable(String throwable) {
            this.throwable = throwable;
        }

        @Override
        public boolean isHealthy() {
            return healthy;
        }

        public Builder healthy(boolean healthy) {
            setHealthy(healthy);
            return this;
        }

        public void setHealthy(boolean healthy) {
            this.healthy = healthy;
        }

        public HealthCheckResultDataImpl build() {
            return new HealthCheckResultDataImpl(this);
        }
    }

    private final String id;
    private final String message;
    private final String throwable;
    private final boolean healthy;

    @JsonCreator
    public HealthCheckResultDataImpl(Builder builder) {
        this.id = builder.id;
        this.message = builder.message;
        this.healthy = builder.healthy;
        this.throwable = builder.throwable;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getThrowable() {
        return throwable;
    }

    @Override
    public boolean isHealthy() {
        return healthy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HealthCheckResultDataImpl)) {
            return false;
        }

        HealthCheckResultDataImpl that = (HealthCheckResultDataImpl) o;

        if (healthy != that.healthy) {
            return false;
        }
        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (message != null ? !message.equals(that.message) : that.message != null) {
            return false;
        }
        if (throwable != null ? !throwable.equals(that.throwable) : that.throwable != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (throwable != null ? throwable.hashCode() : 0);
        result = 31 * result + (healthy ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HealthCheckResultDataImpl{" +
          "id='" + id + '\'' +
          ", message='" + message + '\'' +
          ", throwable=" + (throwable == null? null : "'<...>'") +
          ", healthy=" + healthy +
          '}';
    }
}
