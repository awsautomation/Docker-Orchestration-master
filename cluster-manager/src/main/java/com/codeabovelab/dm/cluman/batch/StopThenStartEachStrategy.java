

package com.codeabovelab.dm.cluman.batch;

import com.codeabovelab.dm.cluman.job.JobComponent;
import com.codeabovelab.dm.cluman.job.JobContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@JobComponent
class StopThenStartEachStrategy {

    protected final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoadContainersOfImageTasklet loader;

    @Autowired
    private StopContainerTasklet containerStopper;

    @Autowired
    private RemoveContainerTasklet containerRemover;

    @Autowired
    private UpgradeImageVersionTasklet imageUpgrader;

    @Autowired
    private CreateContainerTasklet containerCreator;

    @Autowired
    private HealthCheckContainerTasklet healthchecker;

    @Autowired
    private JobContext jobContext;

    @Autowired
    private ContainerConfigTasklet containerConfig;

    /**
     * @param predicate filter containers
     * @param processor change containers
     */
    public void run(ContainerPredicate predicate, ContainerProcessor processor) {
        List<ProcessedContainer> containers = loader.getContainers(predicate);
        updateContainer(containers, processor);
    }

    protected void updateContainer(List<ProcessedContainer> containers, ContainerProcessor processor) {

        for (ProcessedContainer container : containers) {
            try {
                ProcessedContainer withConfig = containerConfig.process(container);
                containerStopper.execute(withConfig);
                containerRemover.execute(withConfig);
                ProcessedContainer newVersion = processor.apply(withConfig);
                ProcessedContainer newContainer = containerCreator.execute(newVersion);
                healthchecker.execute(newContainer);
            } catch (Exception e) {
                jobContext.fire("Error on container {0}", container);
                throw e;
            }
        }

    }
}
