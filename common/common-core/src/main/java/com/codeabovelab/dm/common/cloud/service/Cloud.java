

package com.codeabovelab.dm.common.cloud.service;

import org.springframework.context.annotation.Profile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation indicates that a component is eligible for registration when cloud profile is active.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Profile(Cloud.KEY)
public @interface Cloud {
    String KEY = "cloud";
}
