
package com.codeabovelab.dm.cluman.reconfig;


import java.lang.annotation.*;

/**
 * Marker for reconfigurable bean. If bean implement {@link ReConfigurableAdapter } then this annotation not required.
 * <p/>
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface ReConfigurable {
}
