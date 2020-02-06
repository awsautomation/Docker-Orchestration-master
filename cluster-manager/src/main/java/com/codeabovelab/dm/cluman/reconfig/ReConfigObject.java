

package com.codeabovelab.dm.cluman.reconfig;

import java.lang.annotation.*;

/**
 * May be placed on config object getter and setter, or on appropriate field. <p/>
 * Also, better when getter and setter have specific type instead of common 'Object'.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Inherited
public @interface ReConfigObject {
}
