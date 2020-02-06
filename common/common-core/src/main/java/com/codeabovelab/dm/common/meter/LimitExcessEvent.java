

package com.codeabovelab.dm.common.meter;

import java.util.List;

/**
 * event of limit excess
 */
public final class LimitExcessEvent {
    private final LimitCheckContext limitCheckContext;
    private final List<LimitExcess> excesses;

    LimitExcessEvent(LimitCheckContext limitCheckContext, List<LimitExcess> excesses) {
        this.limitCheckContext = limitCheckContext;
        this.excesses = excesses;
    }

    /**
     * context for limit checkers
     * @return
     */
    public LimitCheckContext getLimitCheckContext() {
        return limitCheckContext;
    }

    /**
     * list of limit excesses
     * @return
     */
    public List<LimitExcess> getExcesses() {
        return excesses;
    }
}
