

package com.codeabovelab.dm.common.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.annotation.SecuredAnnotationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Wrapper for {@link SecuredAnnotationSecurityMetadataSource}
 *
 */
@Component
public class SecuredAnnotationMetadataSource extends SecuredAnnotationSecurityMetadataSource {

    public Collection<ConfigAttribute> fetchAttributes(Class<?> clazz) {
        return findAttributes(clazz);
    }
}
