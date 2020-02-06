
package com.codeabovelab.dm.cluman.job;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Job parameter annotation, properties or fields annotated by this will be set from {@link @com.codeabovelab.dm.cluman.job.JobParameters }.
 * Also parameters which is 'out' can be accessed thought {@link JobContext#getResult(String)}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface JobParam {
    /**
     * Name of param, default use property name.
     * @return
     */
    String value() default "";

    /**
     * If param is not required then it property leave unchanged.
     * @return
     */
    boolean required() default false;

    /**
     * Mean that this parameter is job input argument. Also on methods this is excess, because in/out detected by getter/setter existence.
     * @return
     */
    boolean in() default true;

    /**
     * Mean that this parameter is job result. Also on methods this is excess, because in/out detected by getter/setter existence.
     * @return
     */
    boolean out() default false;
}
