

package com.codeabovelab.dm.cluman.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Map;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class UIPipelinePromote {

    private final String comment;
    private final Map<String, String> arguments;
    private final PipeLineAction action;

}
