

package com.codeabovelab.dm.cluman.job;

import lombok.Data;

/**
 * Criteria for event subscription
 */
@Data
public final class JobEventCriteriaImpl implements JobEventCriteria {

    private final String id;
    private final String type;

    public static boolean matcher(JobEventCriteria pattern, JobEventCriteria event) {
        if(pattern == null) {
            return true;
        }
        String patternId = pattern.getId();
        String patternType = pattern.getType();
        boolean matchId = patternId == null || patternId.equals(event.getId());
        boolean matchType = patternType == null || patternType.equals(event.getType());
        return matchId && matchType;
    }
}
