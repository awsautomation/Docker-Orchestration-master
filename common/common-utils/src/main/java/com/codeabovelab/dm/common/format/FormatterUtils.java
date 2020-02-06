
package com.codeabovelab.dm.common.format;

import com.codeabovelab.dm.common.metatype.MetatypeInfo;
import com.codeabovelab.dm.common.metatype.MetatypeUtils;
import com.codeabovelab.dm.common.utils.Key;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.format.Formatter;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Utils for formatters.
 */
public class FormatterUtils {

    private FormatterUtils() {
    }

    /**
     * Extract handled types from all possible sources (annotation and interface).
     * @param formatter
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Set<Key<?>> getHandledMetatypes(Formatter<?> formatter) {
        Assert.notNull(formatter, "formatter is null");
        Set<Key<?>> set = new HashSet<>();
        if(formatter instanceof SelfDescribedFormatter) {
            set.addAll(((SelfDescribedFormatter) formatter).getHandledMetatypes());
        }
        FormatterInfo formatterInfo = AnnotationUtils.findAnnotation(formatter.getClass(), FormatterInfo.class);
        if(formatterInfo != null) {
            for(MetatypeInfo metatypeInfo: formatterInfo.metatypes()) {
                set.add(MetatypeUtils.toKey(metatypeInfo));
            }
        }
        return set;
    }

    /**
     * Do invocation of specified formatter on text with default locale.
     * @param formatter
     * @param text allow null
     * @param <T>
     * @return parsed object or null if text is null
     */
    public static <T> T parse(Formatter<T> formatter, String text) {
        if(text == null) {
            return null;
        }
        try {
            return formatter.parse(text, Locale.getDefault());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Can not parse:'" + text + "'", e);
        }
    }

    /**
     * Do invocation of specified formatter on value with default locale.
     * @param formatter
     * @param value allow null value
     * @param <T>
     * @return printed text or null if value is null
     */
    public static <T> String print(Formatter<T> formatter, T value) {
        if(value == null) {
            return null;
        }
        return formatter.print(value, Locale.getDefault());
    }
}
