
package com.codeabovelab.dm.cluman.pipeline.schema;

import lombok.Data;

import java.util.List;

/**
 */
@Data
public class PipelineStageSchema {

    private String name;
    private List<String> clusters;
    private List<Action> actions;
    private String tagSuffix = "latest";
    private Boolean autoDeployLatest;

    private List<String> recipients;

}
