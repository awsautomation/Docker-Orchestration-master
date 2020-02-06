
package com.codeabovelab.dm.cluman.ds.clusters;

import com.codeabovelab.dm.cluman.cluster.filter.Filter;
import com.codeabovelab.dm.cluman.cluster.filter.FilterFactory;
import com.codeabovelab.dm.cluman.ds.nodes.NodeRegistration;
import com.codeabovelab.dm.cluman.model.DiscoveryStorage;
import com.codeabovelab.dm.cluman.model.NodesGroup;
import com.codeabovelab.dm.cluman.security.TempAuth;
import org.springframework.util.StringUtils;

/**
 */
class OrphansNodeFilterFactory implements FilterFactory.Factory {

    private static final String PROTO = "nodes-orphan";
    public static final String FILTER = PROTO + ":";

    private final DiscoveryStorage ds;

    OrphansNodeFilterFactory(DiscoveryStorage ds) {
        this.ds = ds;
    }

    @Override
    public Filter create(String expr) {
        return (o) -> {
            String cluster = ((NodeRegistration) o).getNodeInfo().getCluster();
            if(!StringUtils.hasText(cluster)) {
                return true;
            }
            //also we want see nodes which cluster has been deleted
            try(TempAuth ta = TempAuth.asSystem()) {
                NodesGroup group = ds.getCluster(cluster);
                return group == null || !ClusterUtils.isDockerBased(group);
            }
        };
    }

    @Override
    public String getProtocol() {
        return PROTO;
    }
}
