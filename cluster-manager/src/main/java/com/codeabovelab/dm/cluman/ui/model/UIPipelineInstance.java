

package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.cluman.pipeline.instance.State;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Value
@Builder
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class UIPipelineInstance {

    private String id;
    private String pipeline;
    private State state;
    private String name;
    private String registry;
    private Map<String, UIPipelineInstanceHistory> histories;
    private Map<String, String> args;

}
