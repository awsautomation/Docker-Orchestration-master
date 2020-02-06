

package com.codeabovelab.dm.common.meter;

import com.codeabovelab.dm.common.log.BasicLogRecord;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

/**
 * object which contain metric report data with additional fields
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
class MetricReport extends BasicLogRecord {
    public static final String TYPE = "metric";
    private Map<String, Object> metrics;

    public MetricReport() {
        setType(TYPE);
    }

}
