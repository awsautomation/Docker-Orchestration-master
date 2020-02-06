

package com.codeabovelab.dm.cluman.source;

import lombok.Data;
import org.springframework.util.Assert;

/**
 */
@Data
public class DeployOptions {

    @Data
    public static class Builder {

        private DeploySourceJob.ConflictResolution containersConflict = DeploySourceJob.ConflictResolution.LEAVE;

        public Builder containersConflict(DeploySourceJob.ConflictResolution containersConflict) {
            setContainersConflict(containersConflict);
            return this;
        }

        public DeployOptions build() {
            return new DeployOptions(this);
        }
    }

    public static final DeployOptions DEFAULT = builder().build();
    private final DeploySourceJob.ConflictResolution containersConflict;

    public DeployOptions(Builder b) {
        this.containersConflict = b.getContainersConflict();
    }

    public static Builder builder() {
        return new Builder();
    }

    public void validate() {
        Assert.notNull(containersConflict, "containersConflict is null");
    }
}
