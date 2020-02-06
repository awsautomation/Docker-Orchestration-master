

package com.codeabovelab.dm.cluman.batch;

import com.codeabovelab.dm.cluman.job.*;
import com.codeabovelab.dm.cluman.model.DiscoveryStorage;
import com.codeabovelab.dm.cluman.model.NodesGroup;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Data for rollback. <p/>
 * We MUST NOT use here references to any beans, because it object must be serializable to JSON.
 */
@JobIterationComponent
public class RollbackData {

    @Data
    @AllArgsConstructor(onConstructor = @__(@JsonCreator))
    private static class RollbackHandleImpl implements RollbackHandle {
        private final RollbackData data;

        @Override
        public void rollback(RollbackContext rc) {
            // note that it doing in another jobContext
            // and we must again transfer rollback data to new context
            rc.setBean(data);
            DiscoveryStorage discovery = rc.getBean(DiscoveryStorage.class);
            NodesGroup nodesGroup = discovery.getCluster(data.cluster);
            Assert.notNull(nodesGroup, "Can not find cluster: " + data.cluster);
            rc.setBean(nodesGroup, NodesGroup.class);
            RollbackTasklet tasklet = rc.getBean(RollbackTasklet.class);
            tasklet.rollback();
        }
    }

    @Autowired
    private void init(JobContext jobContext) {
        if(jobContext.getAttributes().values().contains(this)) {
            // we in rollback job
            return;
        }
        Assert.isNull(jobContext.getRollback(), "Context already has rollback");
        jobContext.setRollback(new RollbackHandleImpl(this));
    }

    public enum Action {
        CREATE, STOP, DELETE
    }

    public final static class Record {
        final ProcessedContainer container;
        final Action action;

        public Record(ProcessedContainer container, Action action) {
            this.container = container;
            this.action = action;
        }

        @Override
        public String toString() {
            return "Record{" +
              "action=" + action +
              ", container=" + container +
              '}';
        }
    }

    @JobParam(value = BatchUtils.JP_CLUSTER, required = true)
    private String cluster;
    private final List<Record> records = new CopyOnWriteArrayList<>();

    /**
     * Record of attempt to modify container.
     * @param container
     */
    public void record(ProcessedContainer container, Action action) {
        if(action == Action.DELETE) {
            Assert.notNull(container.getSrc(), "Container source is null: we can not rollback it");
        }
        records.add(new Record(container, action));
    }

    List<Record> getRecords() {
        return records;
    }
}
