
package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.cluman.job.JobInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

/**
 */
@Value
@Builder
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class UiJobEvent {
    private final JobInfo info;
    private final LocalDateTime time;
    private final String message;
}
