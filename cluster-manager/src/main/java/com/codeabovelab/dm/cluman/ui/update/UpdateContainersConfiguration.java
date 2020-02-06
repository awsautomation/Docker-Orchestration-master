
package com.codeabovelab.dm.cluman.ui.update;

import com.codeabovelab.dm.cluman.cluster.docker.management.DockerService;
import com.codeabovelab.dm.cluman.job.JobContext;
import com.codeabovelab.dm.cluman.job.JobScope;
import com.codeabovelab.dm.cluman.model.DiscoveryStorage;
import com.codeabovelab.dm.cluman.batch.BatchUtils;
import com.codeabovelab.dm.cluman.batch.UpdateStopThenStartEachJob;
import com.codeabovelab.dm.cluman.model.NodesGroup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.util.Assert;

/**
 * The Configuration.
 */
@Configuration
@ComponentScan(basePackageClasses = UpdateStopThenStartEachJob.class)
public class UpdateContainersConfiguration {

    @Bean
    @Scope(JobScope.SCOPE_NAME)
    DockerService dockerService(NodesGroup nodesGroup) {
        if(nodesGroup == null) {
            return null;
        }
        return nodesGroup.getDocker();
    }

    @Bean
    @Scope(JobScope.SCOPE_NAME)
    NodesGroup nodesGroup(JobContext jobContext, DiscoveryStorage storage) {
        String clusterName = (String) jobContext.getParameters().getParameters().get(BatchUtils.JP_CLUSTER);
        if(clusterName == null) {
            return null;
        }
        NodesGroup cluster = storage.getCluster(clusterName);
        Assert.notNull(cluster, "Can not resolve service for cluster: " + clusterName);
        return cluster;
    }
}
