
package com.codeabovelab.dm.cluman.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Value
@Builder
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class UIPipeline {

    @NotNull
    @ApiModelProperty(value = "Name of pipeline can be equal to filter")
    private final String name;

    @NotNull
    @ApiModelProperty(value = "application/image which will be part of pipeline")
    private final String filter;

    @NotNull
    @ApiModelProperty(value = "upstream registry")
    private final String registry;

    @ApiModelProperty(value = "List of users which will get notifications")
    private final List<String> recipients;

    @NotNull
    private final List<UIPipelineStage> pipelineStages;

}
