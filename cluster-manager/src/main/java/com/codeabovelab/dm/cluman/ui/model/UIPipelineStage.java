

package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.cluman.pipeline.schema.Action;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel(value = "Pipeline stage")
@NoArgsConstructor
@AllArgsConstructor
public class UIPipelineStage {

    private String name;
    @NotNull
    private List<String> clusters;

    @ApiModelProperty(value = "List of hooks which can be runned before or after stage")
    private List<Action> actions;
    private String tagSuffix = "latest";

    @ApiModelProperty(value = "Default false")
    private Boolean autoDeployLatest = false;

    @ApiModelProperty(value = "List of additional recipients for notifications")
    private List<String> recipients;

}
