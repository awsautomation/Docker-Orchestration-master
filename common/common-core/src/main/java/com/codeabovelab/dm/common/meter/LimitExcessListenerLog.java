

package com.codeabovelab.dm.common.meter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * component which report limit excess to log
 */
@Component
public class LimitExcessListenerLog implements LimitExcessListener {
    private static final Logger LOG = LoggerFactory.getLogger(LimitExcessListenerLog.class);

    @Override
    public void listen(LimitExcessEvent event) {
        LOG.error("{} has excesses {}", event.getLimitCheckContext().getMetricId(), event.getExcesses());
    }
}
