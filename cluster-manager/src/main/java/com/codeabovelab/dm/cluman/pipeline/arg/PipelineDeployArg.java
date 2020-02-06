

package com.codeabovelab.dm.cluman.pipeline.arg;

import com.codeabovelab.dm.cluman.model.CreateContainerArg;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class PipelineDeployArg {

    private final String pipelineInstance;
    //    private final String registry;
//    private final String imageId;
    private final String stage;
    private final String comment;
    private final Map<String, String> arguments;
    private final CreateContainerArg createContainerArg;

}
