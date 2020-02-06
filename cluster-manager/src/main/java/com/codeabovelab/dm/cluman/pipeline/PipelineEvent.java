
package com.codeabovelab.dm.cluman.pipeline;

import com.codeabovelab.dm.cluman.model.LogEvent;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Event of pipeline changes.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public final class PipelineEvent extends LogEvent {

    public static class Builder extends LogEvent.Builder<Builder, PipelineEvent> {

        @Override
        public PipelineEvent build() {
            return new PipelineEvent(this);
        }
    }

    /**
     * Id of message bus
     */
    public static final String BUS = "bus.cluman.pipeline";

    @JsonCreator
    public PipelineEvent(Builder b) {
        super(b);
    }

    public static Builder builder() {
        return new Builder();
    }
}
