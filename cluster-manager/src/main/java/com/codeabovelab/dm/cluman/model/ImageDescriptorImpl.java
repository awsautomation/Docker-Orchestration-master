
package com.codeabovelab.dm.cluman.model;

import com.codeabovelab.dm.cluman.cluster.docker.model.ContainerConfig;
import com.google.common.collect.ImmutableMap;
import lombok.Data;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

/**
 */
@Data
public class ImageDescriptorImpl implements ImageDescriptor {

    private final String id;
    private final Date created;
    private final ContainerConfig containerConfig;
    private final Map<String, String> labels;

    @lombok.Builder(builderClassName = "Builder")
    private ImageDescriptorImpl(String id, Date created, ContainerConfig containerConfig, Map<String, String> labels) {
        this.id = id;
        this.created = created;
        this.containerConfig = containerConfig;
        this.labels = labels == null? Collections.emptyMap() : ImmutableMap.copyOf(labels);
    }
}
