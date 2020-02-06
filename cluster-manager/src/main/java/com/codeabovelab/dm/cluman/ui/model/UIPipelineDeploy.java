

package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.cluman.model.ContainerSource;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Value
@Builder
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class UIPipelineDeploy {

    private final String comment;
    private final String stage;

    private final Map<String, String> arguments;

    @ApiModelProperty(value = "Additional container parameters")
    private final ContainerSource uiContainer;


}
