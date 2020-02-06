
package com.codeabovelab.dm.common.format;

import com.codeabovelab.dm.common.utils.Key;
import org.springframework.format.Formatter;

/**
 * The registry which handle mapping for formatters for specific metatypes.
 */
public interface MetatypeFormatterRegistry {
    <T> void addFormatter(Key<T> key, Formatter<T> formatter);
    <T> Formatter<T> getFormatter(Key<T> key);
}
