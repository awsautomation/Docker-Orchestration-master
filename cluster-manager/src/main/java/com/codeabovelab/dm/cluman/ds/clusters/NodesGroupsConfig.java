
package com.codeabovelab.dm.cluman.ds.clusters;

import lombok.Data;

import java.util.List;

/**
 * Config object for nodes groups
 */
@Data
class NodesGroupsConfig {
    private List<AbstractNodesGroupConfig<?>> groups;

}
