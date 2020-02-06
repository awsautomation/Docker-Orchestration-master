

package com.codeabovelab.dm.common.meter;

/**
 * base for limit checkers
 */
public abstract class BaseLimitChecker implements LimitChecker {
    private final long period;

    public BaseLimitChecker(long period) {
        this.period = period;
    }

    @Override
    public long getPeriod() {
        return period;
    }
}
