
package com.codeabovelab.dm.cluman.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class UITokenData {
    private final String userName;
    private final String key;
    private final LocalDateTime creationTime;
    private final LocalDateTime expireAtTime;
}
