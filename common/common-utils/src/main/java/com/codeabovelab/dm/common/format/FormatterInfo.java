
package com.codeabovelab.dm.common.format;

import com.codeabovelab.dm.common.metatype.MetatypeInfo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation which describe metatypes and annotations on which this formatter must be registered
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FormatterInfo {
    /**
     * List of metatypes handled by current formatter.
     * @return
     */
    MetatypeInfo[] metatypes() default {};

    /**
     * List of annotations handled by current formatter.
     * @return
     */
    Class<?>[] annotations() default {};
}
