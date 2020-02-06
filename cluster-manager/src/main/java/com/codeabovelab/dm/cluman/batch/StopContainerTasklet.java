

package com.codeabovelab.dm.cluman.batch;

import com.codeabovelab.dm.cluman.cluster.docker.management.argument.StopContainerArg;
import com.codeabovelab.dm.cluman.cluster.docker.management.result.ServiceCallResult;
import com.codeabovelab.dm.cluman.job.JobComponent;
import com.codeabovelab.dm.cluman.job.JobContext;
import com.codeabovelab.dm.cluman.model.NodesGroup;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Container processor which is stop them
 */
@JobComponent
public class StopContainerTasklet {

    @Autowired
    private NodesGroup nodesGroup;

    @Autowired
    private JobContext context;

    @Autowired
    private RollbackData rollback;

    public void execute(ProcessedContainer item) {
        String id = item.getId();
        StopContainerArg arg = StopContainerArg.builder().id(id).build();
        rollback.record(item, RollbackData.Action.STOP);
        ServiceCallResult res = nodesGroup.getContainers().stopContainer(arg);
        context.fire("Stop container \"{0}\" with result code \"{1}\" and message \"{2}\" (id:{3})", item.getName(), res.getCode(), res.getMessage(), id);
        BatchUtils.checkThatIsOkOrNotModified(res);
    }
}
