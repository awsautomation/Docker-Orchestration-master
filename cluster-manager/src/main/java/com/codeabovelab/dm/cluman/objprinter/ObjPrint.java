
package com.codeabovelab.dm.cluman.objprinter;

import java.lang.annotation.*;

/**
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ObjPrint {
    boolean ignore() default false;
}
