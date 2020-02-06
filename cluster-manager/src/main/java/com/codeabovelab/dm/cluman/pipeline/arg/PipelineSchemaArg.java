
package com.codeabovelab.dm.cluman.pipeline.arg;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 */
@Builder
@Data
public class PipelineSchemaArg {

    private final String name;
    private final String filter;
    private final String registry;
    private final List<PipelineStageSchemaArg> pipelineStages;
    private final List<String> recipients;

}
