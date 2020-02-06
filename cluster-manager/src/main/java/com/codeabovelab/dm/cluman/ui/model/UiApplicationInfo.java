
package com.codeabovelab.dm.cluman.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;

/**
 * Information about application
 */
@Value
@Builder
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class UiApplicationInfo {
    private final String version;
    private final OffsetDateTime buildTime;
    @ApiModelProperty("Git revision")
    private final String buildRevision;
    @ApiModelProperty("host:port address of this application")
    private final String address;
}
