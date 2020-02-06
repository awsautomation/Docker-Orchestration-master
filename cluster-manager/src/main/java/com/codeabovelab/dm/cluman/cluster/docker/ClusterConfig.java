
package com.codeabovelab.dm.cluman.cluster.docker;

import com.codeabovelab.dm.cluman.ds.swarm.Strategies;

import java.util.List;

public interface ClusterConfig {
    String getHost();

    int getMaxCountOfInstances();

    String getDockerRestart();

    String getCluster();

    /**
     * Time in seconds, which data was cached after last write.
     * @return seconds
     */
    long getCacheTimeAfterWrite();

    /**
     * Maximal timeout for docker api access. In seconds. <p/>
     * For some readonly ops, like getinfo, system use small hardcoded timeout.
     * @return timeout in seconds
     */
    int getDockerTimeout();

    List<String> getRegistries();

    Strategies getStrategy();
}
