
package com.codeabovelab.dm.cluman.ds.clusters;

import com.codeabovelab.dm.cluman.model.NodeGroupState;
import com.codeabovelab.dm.cluman.model.NodesGroup;
import com.codeabovelab.dm.cluman.validate.ExtendedAssert;
import org.springframework.util.StringUtils;

import java.util.Set;


public final class ClusterUtils {

    private ClusterUtils() {
    }


    /**
     * Real cluster must contain env name. Like 'envName:clusterName'.
     * @param name
     */
    public static void checkRealClusterName(String name) {
        checkEmpty(name);
    }

    private static void checkEmpty(String name) {
        if(!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("Name is null or empty.");
        }
    }

    /**
     * Report 500 http error when cluster in not OK state.
     * @param nodesGroup cluster
     */
    public static void checkClusterState(NodesGroup nodesGroup) {
        NodeGroupState state = nodesGroup.getState();
        ExtendedAssert.error(state.isOk(), "Cluster '" + nodesGroup.getName() + "' is in no OK state: " + state.getMessage());
    }

    public static boolean isDockerBased(NodesGroup nodesGroup) {
        Set<NodesGroup.Feature> features = nodesGroup.getFeatures();
        return features.contains(NodesGroup.Feature.SWARM) ||
          features.contains(NodesGroup.Feature.SWARM_MODE);
    }
}
