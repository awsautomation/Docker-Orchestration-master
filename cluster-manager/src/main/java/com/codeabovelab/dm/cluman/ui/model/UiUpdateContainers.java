

package com.codeabovelab.dm.cluman.ui.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotNull;


/**
 * POST Data for update containers command
 */
@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class UiUpdateContainers {

    @NotNull
    private final String service;
    @NotNull
    private final String version;
    @NotNull
    private final String strategy;
    private final Float percentage;
    private final boolean healthCheckEnabled;
    private final boolean rollbackEnabled;


}
