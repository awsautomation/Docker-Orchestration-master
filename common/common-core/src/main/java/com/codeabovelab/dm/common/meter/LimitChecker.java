

package com.codeabovelab.dm.common.meter;

/**
 * function which test State of meter and create error object if meters out of specified limit
 */
public interface LimitChecker {
    /**
     * test metric for exceeding of limit
     * @param context
     * @return null if metric stay in limits or LimitExcess instance otherwise
     */
    LimitExcess check(LimitCheckContext context);

    /**
     * period between checks. <p/>
     * now it value used one time, but in future we can implement support for dynamic period checking
     * @return
     */
    long getPeriod();
}
