

package com.codeabovelab.dm.cluman.batch;

import com.codeabovelab.dm.cluman.job.JobBean;
import com.codeabovelab.dm.cluman.ui.update.UpdateContainersUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Stop each container, make updated clone with same name then start it, after repeat for next container.
 */
@JobBean(UpdateContainersUtil.JOB_PREFIX + "stopThenStartEach")
public class UpdateStopThenStartEachJob implements Runnable {

    @Autowired
    private StopThenStartEachStrategy startegy;

    @Autowired
    private UpgradeImageVersionTasklet upgrader;

    @Autowired
    private ContainerNeedUpdatedPredicate predicate;

    @Override
    public void run() {
        startegy.run(predicate, upgrader::execute);
    }
}
