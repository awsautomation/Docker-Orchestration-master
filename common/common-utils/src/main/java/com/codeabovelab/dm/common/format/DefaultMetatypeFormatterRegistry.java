
package com.codeabovelab.dm.common.format;

import com.codeabovelab.dm.common.utils.Key;
import org.springframework.format.Formatter;
import org.springframework.util.Assert;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Default implementation.
 */
public class DefaultMetatypeFormatterRegistry implements MetatypeFormatterRegistry {

    private final ConcurrentMap<Key<?>, Formatter<?>> map = new ConcurrentHashMap<>();

    @Override
    public <T> void addFormatter(Key<T> key, Formatter<T> formatter) {
        Assert.notNull(key, "key is null");
        Assert.notNull(formatter, "formatter is null");
        map.put(key, formatter);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Formatter<T> getFormatter(Key<T> key) {
        Assert.notNull(key, "key is null");
        Formatter<?> formatter = map.get(key);
        if(formatter == null) {
            throw new RuntimeException("No registered formatters for: " + key);
        }
        return (Formatter<T>) formatter;
    }
}
