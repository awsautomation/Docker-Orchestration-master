
package com.codeabovelab.dm.cluman.job;

import com.codeabovelab.dm.cluman.model.EventWithTime;
import com.codeabovelab.dm.common.json.StringConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 */
@Data
public class JobEvent implements JobEventCriteria, EventWithTime {
    public static final String BUS = "bus.cluman.job";
    private final LocalDateTime time = LocalDateTime.now();
    private final JobInfo info;
    private final String message;
    @JsonSerialize(converter = StringConverter.class)
    private final Throwable exception;

    @Override
    public long getTimeInMilliseconds() {
        return time.toEpochSecond(ZoneOffset.UTC);
    }

    @Override
    public String getId() {
        return info.getId();
    }

    @Override
    public String getType() {
        return info.getType();
    }
}
