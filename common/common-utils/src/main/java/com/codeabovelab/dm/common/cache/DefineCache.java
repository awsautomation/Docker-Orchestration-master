

package com.codeabovelab.dm.common.cache;

import java.lang.annotation.*;

/**
 * Annotation for define cache.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
public @interface DefineCache {
    /**
     * Name of cache which is configured by this annotation. If name is absent, then used default cache name.
     * If {@link org.springframework.cache.annotation.Cacheable } define multiple caches and name is
     * absent then exception will be raised.
     * @return
     */
    String name() default "";

    /**
     * Name of cache manager bean
     * @return
     */
    String cacheManager() default "";

    /**
     * Timeout after last writing, after that cached value is expired.
     * Zero value mean that cache never expired, negative value - that cache managed must use default value.
     * @return
     */
    long expireAfterWrite() default -1;

    /**
     * Class of cache invalidator
     * @return
     */
    Class<? extends CacheInvalidator> invalidator() default CacheInvalidator.NullInvalidator.class;

    /**
     * Arguments of cache invalidator. Sequence of key value pairs, like {key1, val1, key2, val2,...}.
     * @return
     */
    String[] invalidatorArgs() default {};
}
