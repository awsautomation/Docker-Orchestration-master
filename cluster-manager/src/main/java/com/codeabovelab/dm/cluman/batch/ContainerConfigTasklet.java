
package com.codeabovelab.dm.cluman.batch;

import com.codeabovelab.dm.cluman.cluster.docker.model.ContainerDetails;
import com.codeabovelab.dm.cluman.job.JobComponent;
import com.codeabovelab.dm.cluman.model.ContainerSource;
import com.codeabovelab.dm.cluman.model.ImageDescriptor;
import com.codeabovelab.dm.cluman.model.NodesGroup;
import com.codeabovelab.dm.cluman.source.ContainerSourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

/**
 * Add current container arguments to processed container
 */
@Slf4j
@JobComponent
public class ContainerConfigTasklet {

    @Autowired
    private NodesGroup nodesGroup;

    @Autowired
    private ContainerSourceFactory containerSourceFactory;

    ProcessedContainer process(ProcessedContainer pc) {
        String id = pc.getId();
        ContainerDetails container = nodesGroup.getContainers().getContainer(id);
        ContainerSource arg = new ContainerSource();
        containerSourceFactory.toSource(container, arg);
        cleanArg(arg, container.getImageId());
        arg.setCluster(pc.getCluster());
        return pc.makeNew().src(arg).build();
    }

    /**
     * Remove env variable and labels inherited from image
     *
     * @param arg
     * @param imageId
     */
    private void cleanArg(ContainerSource arg, String imageId) {
        try {

            ImageDescriptor image = nodesGroup.getDocker().getImage(imageId);
            if (image != null) {

                Set<String> labels = image.getContainerConfig().getLabels().keySet();
                if (!CollectionUtils.isEmpty(labels)) {
                    arg.getLabels().keySet().removeAll(labels);
                }

                List<String> envs = image.getContainerConfig().getEnv();
                if (!CollectionUtils.isEmpty(envs)) {
                    arg.getEnvironment().removeAll(image.getContainerConfig().getEnv());
                }
            }
        } catch (Exception e) {
            log.error("can't clean arg", e);
        }
    }
}
