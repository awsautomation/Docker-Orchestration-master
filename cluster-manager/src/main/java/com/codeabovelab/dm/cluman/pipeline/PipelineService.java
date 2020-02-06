
package com.codeabovelab.dm.cluman.pipeline;

import com.codeabovelab.dm.cluman.pipeline.arg.PipelineDeployArg;
import com.codeabovelab.dm.cluman.pipeline.arg.PipelinePromoteArg;
import com.codeabovelab.dm.cluman.pipeline.arg.PipelineSchemaArg;
import com.codeabovelab.dm.cluman.pipeline.instance.PipelineInstance;
import com.codeabovelab.dm.cluman.pipeline.schema.PipelineSchema;

import java.util.Map;

public interface PipelineService {

    String PIPELINE_NAME = "pipelineName";
    String PIPELINE_STAGE_NAME = "pipelineStageName";
    String PIPELINE_ID = "pipelineId";

    void getOrUpdatePipeline(PipelineSchemaArg pipelineSchema);

    void promote(PipelinePromoteArg pipelinePromoteArg);

    void deploy(PipelineDeployArg pipelineDeployArg);

    void deletePipeline(String pipelineName);

    void deleteInstance(String pipelineName);

    Map<String, PipelineSchema> getPipelinesMap();

    PipelineSchema getPipeline(String pipelineId);

    Map<String, PipelineInstance> getInstancesMap();

    PipelineInstance getInstance(String pipelineInstanceId);

    Map<String, PipelineInstance> getInstancesMapByPipeline(String pipelineId);
}
