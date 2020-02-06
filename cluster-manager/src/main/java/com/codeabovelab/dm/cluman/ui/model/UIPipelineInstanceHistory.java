

package com.codeabovelab.dm.cluman.ui.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class UIPipelineInstanceHistory {

    private final List<String> comments;
    private final String stage;
    private final String tag;

}
