
package com.codeabovelab.dm.cluman.model;

import com.codeabovelab.dm.cluman.cluster.docker.ClusterConfigImpl;
import com.codeabovelab.dm.cluman.ds.clusters.NodesGroupConfig;
import com.codeabovelab.dm.common.json.JtToMap;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Source of cluster. We suppose that cluster can contains multiple applications. But
 * all resources (containers, networks and etc) not owned by app is belong to cluster directly.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@JsonPropertyOrder({"title", "description", "config", "nodes", "applications", "containers"})
public class ClusterSource extends ApplicationSource implements NodesGroupConfig {
    @JtToMap(key = "name")
    @Setter(AccessLevel.NONE)
    private List<ApplicationSource> applications = new ArrayList<>();
    @Setter(AccessLevel.NONE)
    private List<String> nodes = new ArrayList<>();
    private String title;
    private String description;
    private String imageFilter;
    private String type;
    private ClusterConfigImpl config;
}
