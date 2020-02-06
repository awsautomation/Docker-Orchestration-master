

package com.codeabovelab.dm.cluman.batch;

import com.codeabovelab.dm.cluman.job.JobBean;
import com.codeabovelab.dm.cluman.job.JobContext;
import com.codeabovelab.dm.cluman.job.JobParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/**
 * Simple bean with "ping" job, which do nothing. It used for api sampling and testing.
 */
@JobBean("job.sample")
public class SampleJobBean implements Runnable {

    @Autowired
    private JobContext context;

    @JobParam
    private String inParam;

    @JobParam(out = true, in = false)
    private String outParam;

    @Override
    public void run() {
        context.fire("Job is worked.");
        this.outParam = LocalDateTime.now() + " [" + inParam + "]";
        context.setRollback((nc) -> {
            nc.getContext().fire("Job is rollback.");
        });
    }
}
