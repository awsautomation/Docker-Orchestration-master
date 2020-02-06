
package com.codeabovelab.dm.common.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 */
public final class TimeUtils {

    private TimeUtils() {
    }

    /**
     * Convert {@link LocalDateTime } to epoch milliseconds.
     * @param dt date time or null
     * @return milliseconds or Long.MIN_VALUE when argument is null
     */
    public static long toMillis(LocalDateTime dt) {
        if(dt == null) {
            return Long.MIN_VALUE;
        }
        return dt.toInstant(ZoneOffset.UTC).toEpochMilli();
    }
}
