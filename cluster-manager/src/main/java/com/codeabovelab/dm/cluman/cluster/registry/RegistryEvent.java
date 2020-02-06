
package com.codeabovelab.dm.cluman.cluster.registry;

import com.codeabovelab.dm.cluman.model.LogEvent;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RegistryEvent extends LogEvent {

    public static class Builder extends LogEvent.Builder<Builder,RegistryEvent> {

        @Override
        public RegistryEvent build() {
            return new RegistryEvent(this);
        }
    }
    public static final String BUS = "bus.cluman.log.registry";

    @JsonCreator
    public RegistryEvent(Builder b) {
        super(b);
    }

    public static Builder builder() {
        return new Builder();
    }
}
