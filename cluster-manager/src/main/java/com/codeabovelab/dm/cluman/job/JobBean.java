
package com.codeabovelab.dm.cluman.job;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Job bean annotation. Create bean in {@link JobScope#SCOPE_NAME scope }
 * Note that bean must implement {@link Runnable} and can use {@link JobParam } annotation for fields and setters.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
@Scope(value = JobScope.SCOPE_NAME)
public @interface JobBean {
    /**
     * Type identifier of job, default use class name.
     * @return
     */
    String value() default "";

    /**
     * Job bean support repeating, it mean that context of it bean is alive between schedule iteration.
     * It not required for scheduling, because any bean can be scheduled job.
     * @return
     */
    boolean repeatable() default false;

}
