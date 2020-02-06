

package com.codeabovelab.dm.common.log;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UUIDLogRecord extends BasicLogRecord {

    /**
     * UUID of request: uses for merging log entries
     */
    private String requestUID;

}
