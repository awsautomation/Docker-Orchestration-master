
package com.codeabovelab.dm.cluman.cluster.filter;

import com.codeabovelab.dm.cluman.model.WithCluster;

/**
 * Filter which pass objects with `pattern.equals(this.cluster)`.
 * @see com.codeabovelab.dm.cluman.model.WithCluster
 */
public class ClusterFilter implements Filter {

    public static final String PROTO = "cluster";
    private final String pattern;
    private final String expr;

    public ClusterFilter(String pattern) {
        this.pattern = pattern;
        this.expr = PROTO + ":" + pattern;
    }

    @Override
    public boolean test(Object o) {
        String cluster = null;
        if(o instanceof WithCluster) {
            cluster = ((WithCluster) o).getCluster();
        }
        //here we can add some other ways to extract name of cluster
        return pattern.equals(cluster);
    }

    @Override
    public String getExpression() {
        return expr;
    }
}
