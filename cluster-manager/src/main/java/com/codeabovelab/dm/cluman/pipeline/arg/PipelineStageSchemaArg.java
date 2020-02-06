
package com.codeabovelab.dm.cluman.pipeline.arg;

import com.codeabovelab.dm.cluman.pipeline.schema.Action;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 */
@Data
@Builder
public class PipelineStageSchemaArg {

    private final String name;
    private final List<String> clusters;
    //TODO: add sequence
    private final List<Action> actions;
    private final String tagSuffix;
    private final Boolean autoDeployLatest;
    private final List<String> recipients;

}
