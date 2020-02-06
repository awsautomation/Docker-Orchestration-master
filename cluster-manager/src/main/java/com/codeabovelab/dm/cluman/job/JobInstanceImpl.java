
package com.codeabovelab.dm.cluman.job;


class JobInstanceImpl extends AbstractJobInstance {

    JobInstanceImpl(Config config) {
        super(config);
    }

    @Override
    protected boolean innerCancel() throws Exception {
        Boolean res = compareAndSetStatus(JobStatus.STARTED, JobStatus.CANCELLED, () -> {
            this.executeHandle.cancel(true);
            return true;
        });
        return res != null && res;
    }

    @Override
    protected boolean innerStart() throws Exception {
        Boolean res = compareAndSetStatus(JobStatus.CREATED, JobStatus.STARTING, () -> {
            try {
                this.executeHandle = manager.execute(new JobWrapper(this.job));
                setStatus(JobStatus.STARTED);
                return true;
            } catch (Throwable t) {
                setStatus(JobStatus.FAILED_JOB);
                throw t;
            }
        });
        return res != null && res;
    }

    @Override
    protected JobStatus completedStatus() {
        return JobStatus.COMPLETED;
    }

    @Override
    protected JobStatus failedStatus() {
        return JobStatus.FAILED_JOB;
    }

    @Override
    protected void clearAfterIteration() {
        JobScope.getBeans().close();
        JobScopeIteration.getBeans().close();
    }
}
