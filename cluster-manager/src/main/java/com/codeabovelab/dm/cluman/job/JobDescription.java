
package com.codeabovelab.dm.cluman.job;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.collect.ImmutableMap;
import lombok.Data;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Description of job and parameters, can be used for generation ui of job manager.
 */
@Data
public class JobDescription {

    @Data
    public static class Builder {
        private String type;
        private final Map<String, JobParameterDescription> parameters = new HashMap<>();

        public Builder type(String type) {
            setType(type);
            return this;
        }

        public Builder parameter(JobParameterDescription desc) {
            parameters.put(desc.getName(), desc);
            return this;
        }

        public Builder parameters(Map<String, JobParameterDescription> parameters) {
            setParameters(parameters);
            return this;
        }

        public void setParameters(Map<String, JobParameterDescription> parameters) {
            this.parameters.clear();
            if (parameters != null) {
                this.parameters.putAll(parameters);
            }
        }

        public JobDescription build() {
            return new JobDescription(this);
        }
    }

    private final String type;
    private final Map<String, JobParameterDescription> parameters;

    @JsonCreator
    public JobDescription(Builder b) {
        this.type = b.type;
        Assert.hasText(this.type, "Job type must have text");
        this.parameters = ImmutableMap.copyOf(b.parameters);
    }

    public static Builder builder() {
        return new Builder();
    }
}
