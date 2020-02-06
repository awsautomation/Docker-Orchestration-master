
package com.codeabovelab.dm.cluman.model;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Standard actions over objects.
 */
public class StandardActions {
    public static final String CREATE = "create";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";
    public static final String START = "start";
    public static final String STOP = "stop";
    public static final String DIE = "die";
    public static final String ONLINE = "online";
    public static final String OFFLINE = "offline";

    private static final Map<String, Severity> severityMap = ImmutableMap.<String, Severity>builder()
      .put(DIE, Severity.ERROR)
      .put(OFFLINE, Severity.WARNING)
      .build();

    public static Severity toSeverity(String action) {
        Severity severity = severityMap.get(action);
        if(severity == null) {
            severity = Severity.INFO;
        }
        return severity;
    }
}
