

package com.codeabovelab.dm.common.metatype;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface MetatypeInfo {
    /**
     * Name of metatype.
     * @return
     */
    String name();

    /**
     * Type of metatype.
     * @return
     */
    Class<?> type();
}
