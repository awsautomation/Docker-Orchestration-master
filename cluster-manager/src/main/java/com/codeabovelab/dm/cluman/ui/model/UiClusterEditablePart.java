
package com.codeabovelab.dm.cluman.ui.model;

import com.codeabovelab.dm.cluman.cluster.docker.ClusterConfigImpl;
import com.codeabovelab.dm.cluman.ds.clusters.DockerClusterConfig;
import com.codeabovelab.dm.cluman.ds.clusters.NodesGroupConfig;
import com.codeabovelab.dm.common.utils.Keeper;
import com.codeabovelab.dm.common.utils.Sugar;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Part of cluster which is can be edited
 */
@Data
public class UiClusterEditablePart {
    private final Keeper<String> title = new Keeper<>();
    private final Keeper<String> description = new Keeper<>();
    /**
     * SpEL string which applied to images. It evaluated over object with 'tag(name)' and 'label(key, val)' functions,
     * also it has 'r(regexp)' function which can combined with other, like: <code>'spel:tag(r(".*_dev")) or label("dev", "true")'</code>.
     */
    @ApiModelProperty("SpEL string which applied to images. It evaluated over object with 'tag(name)' and 'label(key, val)' functions,\n" +
      "also it has 'r(regexp)' function which can combined with other, like: <code>'spel:tag(r(\".*_dev\")) or label(\"dev\", \"true\")'</code>.")
    private final Keeper<String> filter = new Keeper<>();
    @ApiModelProperty("One of 'SWARM' (standalone swarm cluster), 'DOCKER' (docker in swarm-mode cluster). ")
    private String type;

    private ClusterConfigImpl.Builder config;
    @ApiModelProperty("List of node names which is will be joined into cluster as managers.")
    private List<String> managers;

    public void toCluster(NodesGroupConfig ng) {
        Sugar.setIfChanged(ng::setDescription, getDescription());
        Sugar.setIfChanged(ng::setTitle, getTitle());
        Sugar.setIfChanged(ng::setImageFilter, getFilter());
        if(ng instanceof DockerClusterConfig) {
            DockerClusterConfig dcc = (DockerClusterConfig) ng;
            dcc.setManagers(managers);
        }
    }
}
