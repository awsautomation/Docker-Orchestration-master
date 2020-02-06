

package com.codeabovelab.dm.common.log;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Entity for serializing to logs to JSON
 *
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
class LogEntity extends UUIDLogRecord {
    public static final String TYPE = "log";
    private String user;
    private String loggerName;
    private String level;
    private String threadName;
    private String throwable;

    public LogEntity() {
        setType(TYPE);
    }

}
