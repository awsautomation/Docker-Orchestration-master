

package com.codeabovelab.dm.cluman.batch;

import com.codeabovelab.dm.cluman.cluster.docker.management.argument.DeleteContainerArg;
import com.codeabovelab.dm.cluman.cluster.docker.management.result.ServiceCallResult;
import com.codeabovelab.dm.cluman.job.JobComponent;
import com.codeabovelab.dm.cluman.job.JobContext;
import com.codeabovelab.dm.cluman.model.NodesGroup;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Container processor which is invoke container remove
 */
@JobComponent
public class RemoveContainerTasklet {

    @Autowired
    private NodesGroup nodesGroup;

    @Autowired
    private JobContext context;

    @Autowired
    private RollbackData rollback;

    public void execute(ProcessedContainer item) {
        rollback.record(item, RollbackData.Action.DELETE);
        ServiceCallResult res = nodesGroup.getContainers().deleteContainer(DeleteContainerArg.builder().id(item.getId()).build());
        context.fire("Remove container \"{0}\" with result code \"{1}\" and message \"{2}\" (id:{3})",
          item.getName(),
          res.getCode(),
          res.getMessage(),
          item.getId());
    }
}
