
package com.codeabovelab.dm.cluman.model;

/**
 */
public interface NodeInfoProvider {
    NodeInfo getNodeInfo(String node);

    default String getNodeCluster(String node) {
        NodeInfo nodeInfo = getNodeInfo(node);
        return nodeInfo == null? null : nodeInfo.getCluster();
    }
}
