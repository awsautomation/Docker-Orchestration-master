
package com.codeabovelab.dm.cluman.pipeline.arg;

import com.codeabovelab.dm.cluman.ui.model.PipeLineAction;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PipelinePromoteArg {

    private final String pipelineInstance;
    private final String comment;
    //current stage
    private final String stage;
    private final PipeLineAction action;

}
